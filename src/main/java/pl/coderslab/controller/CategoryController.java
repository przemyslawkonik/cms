package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private CategoryDao categoryDao;

	@Autowired
	public CategoryController(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("categories", categoryDao.findAll());
		return "categories";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("category", new Category());
		return "addCategory";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Category category) {
		categoryDao.save(category);
		return "redirect:/categories";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		categoryDao.remove(id);
		return "redirect:/categories";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("category", categoryDao.findById(id));
		return "addCategory";
	}

	@PostMapping("/edit/{id}")
	public String edit(@ModelAttribute Category category) {
		categoryDao.update(category);
		return "redirect:/categories";
	}

}
