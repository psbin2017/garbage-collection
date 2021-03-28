package com.collection.gc.sample.method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionClassifier {

    public static final String SET_TEXT = "집합";
    public static final String LIST_TEXT = "리스트";
    public static final String OTHER_TEXT = "그 외";

    public static String classify(Set<?> s) {
        return SET_TEXT;
    }

    public static String classify(List<?> list) {
        return LIST_TEXT;
    }

    public static String classify(Collection<?> c) {
        return OTHER_TEXT;
    }

    public static String fixClassify(Collection<?> c) {
        return c instanceof Set ? SET_TEXT :
                c instanceof List ? LIST_TEXT : OTHER_TEXT;
    }

}

class CollectionClassifierTest {

    @Test
    public void 다중정의된_클래스에_명시적으로_Set_던지면_정상인지() throws Exception {
        // given
        Set<String> s = new HashSet<>();

        // when
        String actual = CollectionClassifier.classify(s);

        // then
        Assertions.assertEquals(CollectionClassifier.SET_TEXT, actual);
    }

    @Test
    public void 컴파일타임에_메소드호출이_정해져_의도대로_동작하지_않는지() throws Exception {
        // given
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, String>().values()
        };

        // when
        for (Collection<?> collection : collections) {
            // then
            // 다중정의한 메소드는 정적으로 선택된다.
            Assertions.assertEquals(CollectionClassifier.OTHER_TEXT, CollectionClassifier.classify(collection));
        }
    }
}