package com.collection.gc.sample.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LambdaShortSample {

    @DisplayName("익명 클래스")
    @Test
    public void test_anonymous() {
        List<String> words = getWords();
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println( words.toString() );
    }

    @DisplayName("람다식")
    @Test
    public void test_lambda() {
        List<String> words = getWords();
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println( words.toString() );
    }

    @DisplayName("람다식 2")
    @Test
    public void test_lambda2() {
        List<String> words = getWords();
        Collections.sort(words, Comparator.comparingInt(String::length));
        System.out.println( words.toString() );
    }

    @DisplayName("람다식 3")
    @Test
    public void test_lambda3() {
        List<String> words = getWords();
        words.sort(Comparator.comparingInt(String::length));
        System.out.println( words.toString() );
    }

    private List<String> getWords() {
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList("제이지", "라이언", "죠르디", "어피치", "무지", "펭수"));
        return words;
    }

}
