package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT * FROM article WHERE draft=0 ORDER BY created DESC LIMIT ?1", nativeQuery = true)
	public List<Article> findLatest(int top);

	public List<Article> findByCategoriesId(int id);

	public List<Article> findByDraftEquals(boolean draft);

}
