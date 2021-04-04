package com.collection.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * `@EnableAspectJAutoProxy` {@link com.collection.gc.aspect.LoggingAspect}
 * `@EnableScheduling` {@link com.collection.gc.schedule.ScheduleTasks}}
 * `@EnableCaching` {@link com.collection.gc.cache.service.ToyService#getByTitle(String)}
 */
@EnableAspectJAutoProxy
@EnableScheduling
@EnableCaching
@SpringBootApplication
public class GarbageCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageCollectionApplication.class, args);
	}

}
