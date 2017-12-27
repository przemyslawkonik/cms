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

import pl.coderslab.entity.Article;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.validator.DraftValidationGroup;

@Controller
@RequestMapping("/drafts")
public class DraftController {
	private ArticleRepository artRep;

	@Autowired
	public DraftController(ArticleRepository artRep) {
		this.artRep = artRep;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("drafts", artRep.findByDraftEquals(true));
		return "article/drafts";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("article", new Article());
		return "/article/addDraft";
	}

	@PostMapping("/add")
	public String add(@Validated(DraftValidationGroup.class) @ModelAttribute Article article, BindingResult br) {
		if (br.hasErrors()) {
			return "/article/addDraft";
		}
		artRep.save(article);
		return "redirect:/drafts";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		artRep.delete(id);
		return "redirect:/drafts";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("article", artRep.findOne(id));
		return "/article/addDraft";
	}

	@PostMapping("/edit/{id}")
	public String edit(@Validated(DraftValidationGroup.class) @ModelAttribute Article article, BindingResult br) {
		if (br.hasErrors()) {
			return "/article/addDraft";
		}
		artRep.save(article);
		return "redirect:/drafts";
	}

}
