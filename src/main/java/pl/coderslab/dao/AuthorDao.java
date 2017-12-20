package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Author;

@Repository
@Transactional
public class AuthorDao {
	@PersistenceContext
	EntityManager em;

	public Author save(Author entity) {
		em.persist(entity);
		return entity;
	}

	public List<Author> findAll() {
		return em.createQuery("SELECT a FROM Author a").getResultList();
	}

	public Author findById(int id) {
		return em.find(Author.class, id);
	}

	public Author update(Author entity) {
		return em.merge(entity);
	}

	public void remove(int id) {
		em.remove(findById(id));
	}

}
