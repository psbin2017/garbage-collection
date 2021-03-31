package com.collection.gc.sample.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDiffFlatMapSample {

    @Test
    void map_사용하여_원하는_값을_반환하는지() throws Exception {
        // given
        List<String> list = Arrays.asList("note", "book", "pencil", "pen");

        // when
        long count = list.stream() // Stream<String> → map
                .map(String::toUpperCase)
                .filter("NOTE"::equals)
                .count();
        long expected = 1;

        // then
        assertEquals(expected, count);
    }

    @Test
    void flatMap_사용하여_원하는_값을_반환하는지() throws Exception {
        // given
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = Arrays.asList("note", "book", "pencil", "pen");
        List<String> list2 = Arrays.asList("note", "eraser", "sharp", "note");
        list.add(list1);
        list.add(list2);

        // when
        long count = list.stream() // Stream<List<String>> → flatmap → Stream<String>
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .filter("NOTE"::equals)
                .count();
        long expected = 3;

        // then
        assertEquals(expected, count);
    }

}
