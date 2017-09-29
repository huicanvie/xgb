package cn.tomoya.module.keyword.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tomoya.config.base.BaseController;
import cn.tomoya.config.yml.SiteConfig;
import cn.tomoya.module.keyword.entity.Keyword;
import cn.tomoya.module.keyword.service.KeywordService;
import cn.tomoya.module.section.entity.Section;

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
	 * 关键字列表
	 *
	 * @param p
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Integer p, Model model) {
		Page<Keyword> pageKeywordlist = keywordService.findAll(p == null ? 1 : p, siteConfig.getPageSize());
		model.addAttribute("page", pageKeywordlist);
		return render("/admin/keyword/list");
	}


	/**
	 * 移除关键字
	 *
	 * @param id
	 * @param response
	 * @return
	 */
	@GetMapping("/{id}/remove")
	public String remove(@PathVariable Integer id, HttpServletResponse response) {
		Keyword keyword = keywordService.findById(id);
		keywordService.delete(keyword);
		return redirect(response, "/admin/keywordfilter/list");
	}
	

	/**
	 * 编辑关键字
	 *
	 * @param id
	 * @param response
	 * @return
	 */
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {
		Keyword keyword = keywordService.findById(id);
		model.addAttribute("keyword", keyword);
		return render("/admin/keyword/edit");
	}
	
	/**
	 * 新的关键字
	 *
	 * @param id
	 * @param response
	 * @return
	 */
	@GetMapping("/new")
	public String newKeyword(Model model) {
//		model.addAttribute("keyword", new Keyword());
		return render("/admin/keyword/add");
	}
	
	@PostMapping("/add")
	public String add(String keyword, HttpServletResponse response) {
		Keyword kw = new Keyword();
		kw.setKeyword(keyword);
		
		keywordService.save(kw);
		keywordService.clearCache();
		
	    return redirect(response, "/admin/keywordfilter/list");
	}
	

	@PostMapping("/{id}/update")
	public String update(@PathVariable int id, String keyword, HttpServletResponse response, Model model) {
		Keyword kw = keywordService.findById(id);
		kw.setKeyword(keyword);
		
		keywordService.save(kw);
		keywordService.clearCache();
		
	    return redirect(response, "/admin/keywordfilter/list");
	}
		
}
