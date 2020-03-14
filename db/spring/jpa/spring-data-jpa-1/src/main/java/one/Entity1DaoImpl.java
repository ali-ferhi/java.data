package one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.stereotype.Repository;


@Repository
public class Entity1DaoImpl {
	
	 @PersistenceContext
	 private EntityManager manager;
	 
	 public List<Entity1> read(Integer id) {
		 List<Entity1> toReturn = null;
		 
		 
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<Entity1> query = builder.createQuery(Entity1.class);
		 Root<Entity1> entity1 = query.from(Entity1.class);
		 
		 entity1.fetch("entity3");
		 
		 Predicate predicate1 = builder.equal(entity1.get("id"), id);
		 
		 
		 query.where(predicate1).distinct(true);
		 
		 toReturn = manager.createQuery(query).getResultList();		 
		 return toReturn;
	 }
	 
	 public List<Object[]> read2(Integer id) {
		 List<Object[]> toReturn = null;
		 
		 
		 CriteriaBuilder builder = manager.getCriteriaBuilder();
		 CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		 
		 Root<Entity1> entity1 = query.from(Entity1.class);
		 entity1.fetch("entity3");
		 
		 Root<Entity4> entity4 = query.from(Entity4.class);
		 
		 Predicate predicate1 = builder.equal(entity1.get("id"), id);
		 Predicate predicate2 = builder.equal(entity1.get("id"), entity4.get("entity1Id"));
		 Predicate predicate3 = builder.and(predicate1, predicate2);
		 
		 //Selection<Entity1> select1 = entity1;
		 //Selection<String> select2 = entity4.get("key");
		 query.multiselect(entity1, entity4.get("key")).where(predicate3);
		 
		 toReturn = manager.createQuery(query).getResultList();		 
		 return toReturn;
	 }

}
