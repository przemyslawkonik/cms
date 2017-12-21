package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	private AuthorDao authorDao;

	@Autowired
	public AuthorController(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("authors", authorDao.findAll());
		return "/author/authors";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("author", new Author());
		return "/author/addAuthor";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Author author) {
		authorDao.save(author);
		return "redirect:/authors";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		authorDao.remove(id);
		return "redirect:/authors";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("author", authorDao.findById(id));
		return "/author/addAuthor";
	}

	@PostMapping("/edit/{id}")
	public String edit(@ModelAttribute Author author) {
		authorDao.update(author);
		return "redirect:/authors";
	}

}
