package one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/entity1")
public class Entity1ServiceRest {
	
	@Autowired
	private Entity1Service entity1Service;
	
	@Transactional
	@GetMapping(value="/{id}")
	@ResponseBody
	public Entity1 get(@PathVariable Integer id) {
		
		JndiDataSourceLookup jn;
		
		Entity1 toReturn = entity1Service.read(id);
		return toReturn;
	}

}
