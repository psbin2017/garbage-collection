package com.collection.gc.sample.datastructure;

import java.util.*;

public class PowerSet {
    /*
     * 멱집합
     * {a, b, c}
     *
     * { {}, {a}, {b}, {c}, {a, b}, {a, c}, {b, c}, {a, b, c} }
     *
     * 2^n ... n 은 원소의 개수
     *
     * 2^31 은 Integer.MAX_VALUE 로 제한된다.
     */
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>();
        if ( src.size() > 30) {
            throw new IllegalArgumentException("집합의 원소 개수가 너무 많습니다.: " + s);
        }

        return new AbstractList<Set<E>>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ( (index & 1) == 1 ) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }

            @Override
            public int size() {
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }
        };
    }
}
