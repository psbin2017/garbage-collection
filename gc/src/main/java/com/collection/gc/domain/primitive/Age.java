package com.collection.gc.domain.primitive;

public class Age {
    private int age;

    public Age(int age) {
        if ( age < 0 ) {
            throw new RuntimeException("나이는 음수일 수 없습니다.");
        }
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

}