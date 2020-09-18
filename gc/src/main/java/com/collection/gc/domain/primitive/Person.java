package com.collection.gc.domain.primitive;

/**
 * https://woowacourse.github.io/javable/2020-05-29/wrap-primitive-type
 */
public class Person {
    private Name name;
    private Age age;

    /**
     * 검증에 대한 역할은 회원이 아닌 각 Wrapping 객체가 담당한다.
     */
    public Person(String name, int age) {
        this.name = new Name(name);
        this.age = new Age(age);
    }

    public void aboutMe() {
        System.out.println( "안녕하세요? 제 이름은 " +name.getName()+ "입니다." );
        System.out.println( "나이는 " +age.getAge()+ " 입니다. 잘부탁드립니다~" );
    }

}