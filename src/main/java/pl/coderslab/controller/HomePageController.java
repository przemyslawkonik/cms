package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.ArticleDao;

@Controller
@RequestMapping("")
public class HomePageController {
	private ArticleDao articleDao;
	private final int top = 5;

	@Autowired
	public HomePageController(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@GetMapping("")
	public String showLatestArticles(Model m) {
		m.addAttribute("latestArticles", articleDao.findLatest(top));
		return "home";
	}

}
