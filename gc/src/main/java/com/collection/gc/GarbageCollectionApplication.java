package com.collection.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * `@EnableAspectJAutoProxy` {@link com.collection.gc.aspect.LoggingAspect}
 * `@EnableScheduling` {@link com.collection.gc.schedule.ScheduleTasks}}
 */
@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class GarbageCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbageCollectionApplication.class, args);
	}

}
