package com.collection.gc.sample.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MethodRefSample {

    @Test
    @DisplayName("메소드 참조")
    public void test_methodReference() {
        List<String> list = generate();

        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("람다")
    public void test_lambdaExpression() {
        List<String> list = generate();

        list.stream()
                .map(x -> x.toUpperCase())
                .forEach(x ->
                    System.out.println(x)
                );
    }

    private List<String> generate() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("everyone");
        return list;
    }

}
