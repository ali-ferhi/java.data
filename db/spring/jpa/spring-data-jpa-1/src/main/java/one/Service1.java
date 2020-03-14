package one;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service1 {
	
	@Autowired
	private Entity1Service entity1Service;
	
	@Autowired
	private Entity2Service entity2Service;
	
	public void create() {
		Entity1 entity1_1 = new Entity1();
	    entity1_1.setId(101);
	    entity1_1.setKey("key1_1");
	    entity1_1.setValue("value1_1");
	    entity1Service.create(entity1_1);
	    
	    Entity2 entity2_1 = new Entity2();
	    entity2_1.setId(201);
	    entity2_1.setKey("key2_1");
	    entity2_1.setValue("value2_1");
	    entity2_1.setEntity1(entity1_1);
	    entity2Service.create(entity2_1);
	    
	}
	
	@Transactional(transactionManager = "transactionManager1", readOnly = true)
	public void read() {
		Entity1 entity1_1 = entity1Service.read(101);
		
		Entity2 entity2_1 = entity2Service.read(201);
	    Entity1 entity1_1_ = entity2_1.getEntity1();
	    String value = entity1_1_.getValue();
	}
	
	@Transactional(transactionManager = "transactionManager1", readOnly = true)
	public void readViaDaoImpl() {
		List<Entity1> listEntity1 = entity1Service.readViaDaoImpl(101);
		for(Entity1 entity1 : listEntity1) {
			System.out.println("entity1.key = " + entity1.getKey());
			List<Entity3> listEntity3 = entity1.getEntity3();
			Entity3 entity3 = listEntity3.get(0);
			System.out.println("entity3.key = " + entity3.getKey());
		}
	}
	
	@Transactional(transactionManager = "transactionManager1", readOnly = true)
	public void read2ViaDaoImpl() {
		List<Object[]> list = entity1Service.read2ViaDaoImpl(101);
		System.out.println("list.size = " + list.size());
	}

}
