package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	private AuthorRepository authRep;

	@Autowired
	public AuthorController(AuthorRepository authRep) {
		this.authRep = authRep;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("authors", authRep.findAll());
		return "/author/authors";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("author", new Author());
		return "/author/addAuthor";
	}

	@PostMapping("/add")
	public String add(@Valid @ModelAttribute Author author, BindingResult br) {
		if (br.hasErrors()) {
			return "/author/addAuthor";
		}
		authRep.save(author);
		return "redirect:/authors";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		authRep.delete(id);
		return "redirect:/authors";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("author", authRep.findOne(id));
		return "/author/addAuthor";
	}

	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute Author author, BindingResult br) {
		if (br.hasErrors()) {
			return "/author/addAuthor";
		}
		authRep.save(author);
		return "redirect:/authors";
	}

}
