package one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Entity2Service {
	
	@Autowired
	private Entity2Dao dao;
	
	public void create(Entity2 entity2) {
		dao.save(entity2);
	}
	
	public Entity2 read(Integer id) {
		Entity2 toReturn = dao.findOne(id);
		return toReturn;
	}

}
