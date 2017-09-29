package cn.tomoya.module.blacklist.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.tomoya.config.base.BaseController;
import cn.tomoya.config.yml.SiteConfig;
import cn.tomoya.module.blacklist.entity.Blacklist;
import cn.tomoya.module.blacklist.service.BlacklistService;
import cn.tomoya.module.user.entity.User;
import cn.tomoya.module.user.service.UserService;

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
	@Autowired
	private UserService userService;

	/**
	 * 用户列表
	 *
	 * @param p
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Integer p, Model model) {
		// Page<Blacklist> pageUser = blacklistService.pageUser(p == null ? 1 : p,
		// siteConfig.getPageSize());
		Page<Blacklist> pageBlacklist = blacklistService.findAll(p == null ? 1 : p, siteConfig.getPageSize());

		// List<Blacklist> content = pageBlacklist.getContent();
		// Blacklist blacklist = content.get(0);
		// User user = blacklist.getUser();
		// System.out.println(">>>>>>>>>>>>>>>>>>>>>" + user.getUsername());
		// System.out.println(pageBlacklist);

		model.addAttribute("page", pageBlacklist);

		// User u = new User();
		// u.setId(1);
		// Blacklist findListByUserId = blacklistService.findByUserId(u);
		// User user2 = findListByUserId.getUser();
		// System.out.println("<<<<<<<<<<<<<<<<<<<<" + user2.getUsername());
		//
		//// List listByUserId = blacklistService.getListByUserId(1);
		//// System.out.println(listByUserId.size());
		//
		// User uu = userService.findById(2);
		// Blacklist b = blacklistService.findByUserId(uu);
		// b.setUser(uu);
		//
		//// blacklistService.save(b);
		//// blacklistService.sava(b);
		//
		// blacklistService.delete(b);

		return render("/admin/blacklist/list");
	}

	/**
	 * 移除黑名单用户
	 *
	 * @param id
	 * @param response
	 * @return
	 */
	@GetMapping("/{id}/unblack")
	public String unblack(@PathVariable Integer id, HttpServletResponse response) {
		Blacklist b = blacklistService.findById(id);
		blacklistService.delete(b);

		return redirect(response, "/admin/blacklist/list");
	}

	/**
	 * 加入黑名单用户
	 *
	 * @param id
	 * @param response
	 * @return
	 */
	@GetMapping("/{id}/black")
	public String black(@PathVariable Integer id, HttpServletResponse response) {
		User uu = userService.findById(id);
		Blacklist b = new Blacklist();
		b.setUser(uu);
		blacklistService.save(b);

		return redirect(response, "/admin/user/list");
	}

}
