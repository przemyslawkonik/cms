package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	private ArticleDao articleDao;
	private AuthorDao authorDao;

	@Autowired
	public ArticleController(ArticleDao articleDao, AuthorDao authorDao) {
		this.articleDao = articleDao;
		this.authorDao = authorDao;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("articles", articleDao.findAll());
		return "/article/articles";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("article", new Article());
		return "/article/addArticle";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Article article) {
		articleDao.save(article);
		return "redirect:/articles";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		articleDao.remove(id);
		return "redirect:/articles";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("article", articleDao.findById(id));
		return "/article/addArticle";
	}

	@PostMapping("/edit/{id}")
	public String edit(@ModelAttribute Article article) {
		articleDao.update(article);
		return "redirect:/articles";
	}

	@ModelAttribute("authors")
	public List<Author> getAuthors() {
		return authorDao.findAll();
	}

}
