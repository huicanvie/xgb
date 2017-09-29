package cn.tomoya.module.blacklist.controller;

import java.util.List;

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
import cn.tomoya.module.user.entity.User;

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
//		Page<Blacklist> pageUser = blacklistService.pageUser(p == null ? 1 : p, siteConfig.getPageSize());
		Page<Blacklist> pageUser = blacklistService.findAll(p == null ? 1 : p, siteConfig.getPageSize());
		List<Blacklist> content = pageUser.getContent();
		Blacklist blacklist = content.get(0);
		User user = blacklist.getUser();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>" + user.getUsername());
		System.out.println(pageUser);
		
		// model.addAttribute("page", pageUser);
		
		User u = new User();
		u.setId(1);
		Blacklist findListByUserId = blacklistService.findByUserId(u);
		User user2 = findListByUserId.getUser();
		System.out.println("<<<<<<<<<<<<<<<<<<<<" + user2.getUsername());
		
//		List listByUserId = blacklistService.getListByUserId(1);
//		System.out.println(listByUserId.size());
		
		User u1 = new User();
		u1.setId(2);
		blacklistService.sava(u1);
		
		return render("/admin/blacklist/list");
	}

}
