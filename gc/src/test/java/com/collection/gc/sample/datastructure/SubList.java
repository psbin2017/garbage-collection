package com.collection.gc.sample.datastructure;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubList {

    public static <E> Stream<List<E>> of(List<E> list) {

        /*
         * Stream.concat: 반환 스트림에 빈 리스트를 추가한다.
         *
         * .flatMap: 모든 프리픽스와 서픽스로 구성된 하나의 스트림으로 구성한다.
         */
        return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubList::suffixes));
    }

    public static <E> Stream<List<E>> ofNotSeparate(List<E> list) {
        return IntStream.range(0, list.size())
                    .mapToObj(start -> IntStream.rangeClosed(start + 1, list.size())
                            .mapToObj(end -> list.subList(start, end))).flatMap(x -> x);
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        /*
         * IntStream.range 순차적으로 주문된 `IntStream` 을 시작 포괄(포함)에서 1의 증분 단계로 독점(독점)으로 종료한다.
         */
        return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        /*
         * IntStream.rangeClosed 순차적으로 정렬된 `IntStream` 을 시작 포괄(포함)에서 1의 증분 단계로 포함(포함)으로 종료한다.
         */
        return IntStream.rangeClosed(1, list.size()).mapToObj(end -> list.subList(0, end));
    }
}