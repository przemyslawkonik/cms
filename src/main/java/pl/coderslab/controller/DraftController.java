package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.validator.DraftValidationGroup;

@Controller
@RequestMapping("/drafts")
public class DraftController {
	private ArticleDao articleDao;

	@Autowired
	public DraftController(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("drafts", articleDao.findAllDrafts());
		return "article/drafts";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("draft", new Article());
		return "/article/addDraft";
	}

	@PostMapping("/add")
	public String add(@Validated(DraftValidationGroup.class) @ModelAttribute Article draft, BindingResult br) {
		if (br.hasErrors()) {
			return "/article/addDraft";
		}
		articleDao.save(draft);
		return "redirect:/drafts";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		articleDao.remove(id);
		return "redirect:/drafts";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("draft", articleDao.findById(id));
		return "/article/addDraft";
	}

	@PostMapping("/edit/{id}")
	public String edit(@Validated(DraftValidationGroup.class) @ModelAttribute Article draft, BindingResult br) {
		if (br.hasErrors()) {
			return "/article/addDraft";
		}
		articleDao.update(draft);
		return "redirect:/drafts";
	}

}
