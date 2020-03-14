package one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Entity1Service {
	
	@Autowired
	private Entity1Dao dao;
	
	public void create(Entity1 entity1) {
		dao.save(entity1);
	}
	
	public Entity1 read(Integer id) {
		Entity1 toReturn = dao.findOne(id);
		return toReturn;
	}

}
