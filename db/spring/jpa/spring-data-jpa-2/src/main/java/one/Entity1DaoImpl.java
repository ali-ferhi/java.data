package one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


@Repository
public class Entity1DaoImpl {
	
	 @PersistenceContext
	 private EntityManager em;
	 
	 public List<Entity1> readAll() {
		 List<Entity1> toReturn = null;
		 
		 CriteriaQuery<Entity1> criteriaQuery = em.getCriteriaBuilder().createQuery(Entity1.class);
		 Root<Entity1> root = criteriaQuery.from(Entity1.class);
		 toReturn = em.createQuery(criteriaQuery).getResultList();
		 
		 return toReturn;
	 }

}
