package it.infinispan1.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryModified;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryModifiedEvent;

@Listener
public class Listener1 {
	
	@CacheEntryCreated
    public void entryCreated(CacheEntryCreatedEvent<String, String> event) {
       if (!event.isPre())
          System.out.printf("added entry : %s\n", event.getKey());
    }

    @CacheEntryModified
    public void entryModified(CacheEntryModifiedEvent<String, String> event) {
       if (event.isPre())
          System.out.printf("modified entry : %s\n", event.getKey());
    }

}
