package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;

@Controller
@RequestMapping("")
public class HomePageController {
	private ArticleDao articleDao;
	private CategoryDao categoryDao;
	private final int top = 5;

	@Autowired
	public HomePageController(ArticleDao articleDao, CategoryDao categoryDao) {
		this.articleDao = articleDao;
		this.categoryDao = categoryDao;
	}

	@GetMapping("")
	public String showLatestArticles(Model m) {
		m.addAttribute("latestArticles", articleDao.findLatest(top));
		m.addAttribute("categories", categoryDao.findAll());
		return "home";
	}

	@PostMapping("")
	public String showCategory(Model m, @RequestParam int categoryId) {
		m.addAttribute("category", categoryDao.findById(categoryId));
		m.addAttribute("categoryArticles", articleDao.findByCategoryId(categoryId));
		return "category";
	}

}
