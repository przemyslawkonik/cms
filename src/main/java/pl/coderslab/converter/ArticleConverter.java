package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

public class ArticleConverter implements Converter<String, Article> {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public Article convert(String source) {
		return articleDao.findById(Integer.parseInt(source));
	}
}
