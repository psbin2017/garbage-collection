package com.collection.gc.nested;

import java.util.AbstractList;
import java.util.List;

/**
 * 익명 클래스
 * - 익명 클래스는 멤버가 아니다.
 * - 람다를 생각하라.
 */
public class AnonymousClassSample {

    public List<String> anonymous() {
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

}