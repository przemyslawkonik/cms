package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	private AuthorRepository ar;

	@Override
	public Author convert(String source) {
		return ar.findOne(Integer.parseInt(source));
	}
}
