package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CategoryRepository;

@Controller
@RequestMapping("")
public class HomePageController {
	private ArticleRepository artRep;
	private CategoryRepository catRep;
	private final int top = 5;

	@Autowired
	public HomePageController(CategoryRepository catRep, ArticleRepository artRep) {
		this.catRep = catRep;
		this.artRep = artRep;
	}

	@GetMapping("")
	public String showLatestArticles(Model m) {
		m.addAttribute("latestArticles", artRep.findLatest(top));
		m.addAttribute("categories", catRep.findAll());
		return "home";
	}

	@PostMapping("")
	public String showCategory(Model m, @RequestParam int categoryId) {
		m.addAttribute("category", catRep.findOne(categoryId));
		m.addAttribute("categoryArticles", artRep.findByCategoriesId(categoryId));
		return "/category/category";
	}

}
