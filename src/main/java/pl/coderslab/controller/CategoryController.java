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

import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	private CategoryRepository catRep;

	@Autowired
	public CategoryController(CategoryRepository categoryDao) {
		this.catRep = categoryDao;
	}

	@GetMapping("")
	public String show(Model m) {
		m.addAttribute("categories", catRep.findAll());
		return "/category/categories";
	}

	@GetMapping("/add")
	public String add(Model m) {
		m.addAttribute("category", new Category());
		return "/category/addCategory";
	}

	@PostMapping("/add")
	public String add(@Valid @ModelAttribute Category category, BindingResult br) {
		if (br.hasErrors()) {
			return "/category/addCategory";
		}
		catRep.save(category);
		return "redirect:/categories";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		catRep.delete(id);
		return "redirect:/categories";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model m, @PathVariable int id) {
		m.addAttribute("category", catRep.findOne(id));
		return "/category/addCategory";
	}

	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute Category category, BindingResult br) {
		if (br.hasErrors()) {
			return "/category/addCategory";
		}
		catRep.save(category);
		return "redirect:/categories";
	}

}
