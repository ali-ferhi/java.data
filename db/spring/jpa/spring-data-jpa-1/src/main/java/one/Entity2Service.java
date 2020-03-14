package one;

import java.util.Optional;

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
		Optional<Entity2> entity2 = dao.findById(id);
		Entity2 toReturn = entity2.get();
		return toReturn;
	}

}
