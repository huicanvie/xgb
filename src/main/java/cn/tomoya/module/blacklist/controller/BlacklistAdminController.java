package cn.tomoya.module.blacklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tomoya.config.base.BaseController;
import cn.tomoya.config.yml.SiteConfig;
import cn.tomoya.module.blacklist.entity.Blacklist;
import cn.tomoya.module.blacklist.service.BlacklistService;

/**
 * 黑名单
 */
@Controller
@RequestMapping("/admin/blacklist")
public class BlacklistAdminController extends BaseController {

  @Autowired
  private SiteConfig siteConfig;
  @Autowired
  private BlacklistService blacklistService;

  /**
   * 用户列表
   *
   * @param p
   * @param model
   * @return
   */
  @GetMapping("/list")
  public String list(Integer p, Model model) {
    Page<Blacklist> pageUser = blacklistService.pageUser(p == null ? 1 : p, siteConfig.getPageSize());
	model.addAttribute("page", pageUser);
    return render("/admin/blacklist/list");
  }

}
