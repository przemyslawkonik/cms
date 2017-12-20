package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Category;

@Repository
@Transactional
public class CategoryDao {
	@PersistenceContext
	EntityManager em;

	public Category save(Category entity) {
		em.persist(entity);
		return entity;
	}

	public List<Category> findAll() {
		return em.createQuery("SELECT c FROM Category c").getResultList();
	}

	public Category findById(int id) {
		return em.find(Category.class, id);
	}

	public Category update(Category entity) {
		return em.merge(entity);
	}

	public void remove(int id) {
		em.remove(findById(id));
	}

}
