package com.collection.gc.sample.serializable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonSample {
    
    @DisplayName("todo")
    @Test
    public void todo() {

    }

}

class FieldFinalWaySingleton {
    public static final FieldFinalWaySingleton INSTANCE = new FieldFinalWaySingleton();

    private FieldFinalWaySingleton() { }

    public void leaveTheBuilding() {
        System.out.println("FieldFinalWaySingleton");
    }
}

/**
 * 1. 클레스에서 싱글톤 할당
 * 2. 객체 사용 유무와 관계 없이 INSTANCE 가 할당
 *
 * thread safe
 */
class StaticFinalWaySingleton {
    private static final StaticFinalWaySingleton INSTANCE = new StaticFinalWaySingleton();
    private StaticFinalWaySingleton() { }

    public static StaticFinalWaySingleton getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("StaticFinalWaySingleton");
    }
}

/**
 * 1. 클래스에 이너 클래스 제공
 * 2. 이너 클래스는 싱글톤 할당
 * 3. 실제로 LazyHolderSingleton.getInstance() 가 호출되면 클래스 로더가 INSTANCE 객체를 생성하여 할당
 *
 * thread safe
 */
class LazyHolderSingleton {
    private LazyHolderSingleton() { }

    private static class LazyHolder {
        public static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
    }

    public static LazyHolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
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