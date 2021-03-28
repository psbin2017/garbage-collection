package com.collection.gc.sample.method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {

    @Test
    public void 다중정의로_의도된대로_제거되지_않는지() throws Exception {
        // given
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        // when
        for ( int i = -3; i < 3; i++ ) {
            set.add(i);
            list.add(i);
        }

        for ( int i = 0; i < 3; i++ ) {
            set.remove(i); // remove(Object)
            list.remove(i); // remove(int index)
        }

        // then
        System.out.println(set.toString());
        System.out.println(list.toString());

        Assertions.assertFalse(set.toString().equals( list.toString() ));
    }

    @Test
    public void 다중정의로_의도된대로_제거되는지() throws Exception {
        // given
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        // when
        for ( int i = -3; i < 3; i++ ) {
            set.add(i);
            list.add(i);
        }

        for ( int i = 0; i < 3; i++ ) {
            set.remove(i); // remove(Object)
            list.remove((Integer) i); // remove(Object)
        }

        // then
        System.out.println(set.toString());
        System.out.println(list.toString());

        Assertions.assertTrue(set.toString().equals( list.toString() ));
    }
}
