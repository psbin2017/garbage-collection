package com.collection.gc.sample.method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Wine {
    String name() {
        return "포도주";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "발포성 포도주";
    }
}

class Champagne extends Wine {
    @Override
    String name() {
        return "샴페인";
    }
}

class WineTest {

    @Test
    public void 컴파일타임에_와인이어도_하위타입에서_재정의한_메소드를_호출하는지() throws Exception {
        // given
        List<Wine> wineList = new ArrayList<Wine>(){{
            add(new SparklingWine());
            add(new SparklingWine());
            add(new Champagne());
            add(new Champagne());
        }};

        for (Wine wine : wineList) {
            Assertions.assertNotEquals("포도주", wine.name());
        }
    }

}