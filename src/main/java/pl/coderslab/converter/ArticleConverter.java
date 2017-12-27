package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Article;
import pl.coderslab.repository.ArticleRepository;

public class ArticleConverter implements Converter<String, Article> {

	@Autowired
	private ArticleRepository artRep;

	@Override
	public Article convert(String source) {
		return artRep.findOne(Integer.parseInt(source));
	}
}
