package com.collection.gc.designpattern.singleton;

/**
 * Singleton LazyHolder
 *
 * @See com.collection.gc.sample.serializable.SingletonSample
 */
public class MyPersonalPC {

    private MyPersonalPC() { }

    public MyPersonalPC getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final MyPersonalPC INSTANCE = new MyPersonalPC();
    }

}
