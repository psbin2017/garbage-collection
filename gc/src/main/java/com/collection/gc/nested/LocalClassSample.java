package com.collection.gc.nested;

/**
 * 지역 클래스
 * - 지역변수와 같은 스코프를 가진다.
 * - 바깥 클래스의 인스턴스를 참조할 수 있다.
 */
public class LocalClassSample {

    public void local() {
        int number = 10;
        final int finalNumber = 20;

        class LocalClass {

            // jdk 1.8 부터는 final 생략 가능
            int localNumber = number;
            final int localFinalNumber = finalNumber;

            void todo() {
                // 외부 객체의 참조를 가질 수 있다.
                LocalClassSample localClassSample = LocalClassSample.this;
                localClassSample.doSomething();
            }
        }
    }

    public void doSomething() {
        System.out.println("hello");
    }

}
