package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Article;

@Repository
@Transactional
public class ArticleDao {
	@PersistenceContext
	EntityManager em;

	public Article save(Article entity) {
		em.persist(entity);
		return entity;
	}

	public List<Article> findAll() {
		return em.createQuery("SELECT a FROM Article a").getResultList();
	}

	public List<Article> findLatest(int top) {
		return em.createQuery("SELECT a FROM Article a ORDER BY a.created").setMaxResults(top).getResultList();
	}

	public List<Article> findByCategoryId(int id) {
		return em.createQuery("SELECT a FROM Article a JOIN a.categories c WHERE c.id=:categoryId")
				.setParameter("categoryId", id).getResultList();
	}

	public Article findById(int id) {
		return em.find(Article.class, id);
	}

	public Article update(Article entity) {
		return em.merge(entity);
	}

	public void remove(int id) {
		em.remove(findById(id));
	}

}
