package com.collection.gc.cache.service;

import com.collection.gc.cache.domain.Toy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ToyService {

    /**
     * Cacheable
     */
    @Cacheable("toy")
    public Toy getByTitle(String title) {
        dontTryAtHome();
        return new Toy(title);
    }

    private void dontTryAtHome() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
