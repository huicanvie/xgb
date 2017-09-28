package cn.tomoya.module.keyword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tomoya.config.base.BaseController;
import cn.tomoya.config.yml.SiteConfig;
import cn.tomoya.module.keyword.service.KeywordService;

/**
 * 关键字
 */
@Controller
@RequestMapping("/admin/keywordfilter")
public class KeywordAdminController extends BaseController {

  @Autowired
  private SiteConfig siteConfig;
  @Autowired
  private KeywordService keywordService;

  /**
   * 用户列表
   *
   * @param p
   * @param model
   * @return
   */
  @GetMapping("/list")
  public String list(Integer p, Model model) {
//    model.addAttribute("page", blacklistService.pageUser(p == null ? 1 : p, siteConfig.getPageSize()));
    return render("/admin/keyword/list");
  }

}
