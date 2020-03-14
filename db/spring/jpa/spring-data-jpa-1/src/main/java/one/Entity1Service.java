package one;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Entity1Service {
	
	@Autowired
	private Entity1Dao dao;
	
	@Autowired
	private Entity1DaoImpl daoImpl;
	
	public void create(Entity1 entity1) {
		dao.save(entity1);
	}
	
	public Entity1 read(Integer id) {
		Optional<Entity1> entity1 = dao.findById(id);
		Entity1 toReturn = entity1.get();
		return toReturn;
	}
	
	public List<Entity1> readViaDaoImpl(Integer id) {
		List<Entity1> toReturn = null;
		toReturn = daoImpl.read(id);
		return toReturn;
	}

	
	public List<Object[]> read2ViaDaoImpl(Integer id) {
		List<Object[]> toReturn = null;
		toReturn = daoImpl.read2(id);
		return toReturn;
	}
}
