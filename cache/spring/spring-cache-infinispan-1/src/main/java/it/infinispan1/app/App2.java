package it.infinispan1.app;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

import it.infinispan1.listener.Listener1;

public class App2 {
	
	public static void main(String[] args) {
		
		DefaultCacheManager cacheManager = new DefaultCacheManager();		
        cacheManager.defineConfiguration("local", new ConfigurationBuilder().build());

        Cache<String, String> cache = cacheManager.getCache("local");
        cache.addListener(new Listener1());

        System.out.printf("adding entry : key1\n");
        cache.put("key1", "value1");
        System.out.printf("adding entry : key2\n");
        cache.put("key2", "value2");
        System.out.printf("modifing entry : key2\n");
        cache.put("key2", "value2_1");

        System.out.printf("value of key1 = %s\n", cache.get("key1"));
        System.out.printf("value of key2 = %s\n", cache.get("key2"));
        
        cacheManager.stop();
	}

}
