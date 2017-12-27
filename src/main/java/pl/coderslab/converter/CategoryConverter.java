package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryRepository cr;

	@Override
	public Category convert(String source) {
		return cr.findOne(Integer.parseInt(source));
	}
}
