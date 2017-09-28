package cn.tomoya.config.freemarker;

import cn.tomoya.config.yml.SiteConfig;
import cn.tomoya.module.user.entity.User;
import cn.tomoya.module.user.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by tomoya on 17-6-12.
 */
@Component
public class ScoreDirective implements TemplateDirectiveModel {

  @Autowired
  private UserService userService;
  @Autowired
  private SiteConfig siteConfig;

  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);

    int p = map.get("p") == null ? 1 : Integer.parseInt(map.get("p").toString());
    int limit = map.get("limit") == null ? siteConfig.getPageSize() : Integer.parseInt(map.get("limit").toString());

    Page<User> page = userService.findByScore(p, limit);

    environment.setVariable("page", builder.build().wrap(page));

    templateDirectiveBody.render(environment.getOut());
  }
}