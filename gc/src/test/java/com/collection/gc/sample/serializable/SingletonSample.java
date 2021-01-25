package com.collection.gc.sample.serializable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonSample {
    
    @DisplayName("todo")
    @Test
    public void todo() {
        // TODO
    }

}

class FieldFinalWaySingleton {
    public static final FieldFinalWaySingleton INSTANCE = new FieldFinalWaySingleton();

    private FieldFinalWaySingleton() { }

    public void leaveTheBuilding() {
        System.out.println("FieldFinalWaySingleton");
    }
}

class StaticFinalWaySingleton {
    private static final StaticFinalWaySingleton INSTANCE = new StaticFinalWaySingleton();
    private StaticFinalWaySingleton() { }

    public static final StaticFinalWaySingleton getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("StaticFinalWaySingleton");
    }
}

/**
 * enum 은 class 와 다르게 직렬화한다.
 */
enum EnumWaySingleton {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("EnumWaySingleton");
    }
}