package com.collection.gc.sample.method;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class OptionalReturn {

    /**
     * 빈 컬렉션은 예외를 던진다
     */
    public static <E extends Comparable<E>> E maxException(Collection<E> c) {
        if ( c.isEmpty() ) {
            throw new IllegalArgumentException("빈 컬렉션");
        }
        E result = null;
        for (E e : c) {
            if ( result == null || e.compareTo(result) > 0 ) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    /**
     * 빈 컬렉션은 빈 옵셔널을 반환한다.
     *
     * 옵셔널을 반환하는 메소드는 절대 null 을 반환하지 말자
     */
    public static <E extends Comparable<E>> Optional<E> maxOptional(Collection<E> c) {
        if ( c.isEmpty() ) {
            return Optional.empty();
        }
        E result = null;
        for (E e : c) {
            if ( result == null || e.compareTo(result) > 0 ) {
                result = Objects.requireNonNull(e);
            }
        }
        return Optional.of(result);
    }

    /**
     * 스트림 버전
     *
     * 한줄로 다이어트 성공
     */
    public static <E extends Comparable<E>> Optional<E> maxStream(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

}
