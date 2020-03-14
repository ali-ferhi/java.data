package it.infinispan1.app;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class App1 {

	public static void main(String[] args) {
		DefaultCacheManager m = new DefaultCacheManager();
		Cache<String, String> c = m.getCache();
		c.put("hello", "world");

	}

}
