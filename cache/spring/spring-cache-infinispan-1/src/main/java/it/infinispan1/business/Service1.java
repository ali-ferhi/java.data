package it.infinispan1.business;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import it.infinispan1.model.Entity1;

@Service
public class Service1 {
	
	
	public Entity1 get1(Integer id) {
		Entity1 toReturn = get1Cacheable(id);
		return toReturn;
	}
	
	@Cacheable("cache1")
	public Entity1 get1Cacheable(Integer id) {
		Entity1 toReturn = new Entity1(id, "salam");
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
		return toReturn;
	}

}
