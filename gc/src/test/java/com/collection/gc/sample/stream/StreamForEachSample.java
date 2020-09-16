package com.collection.gc.sample.stream;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://woowacourse.github.io/javable/2020-05-14/foreach-vs-forloop
 */
public class StreamForEachSample {

    @DisplayName("좋은 케이스: forEach 는 println 만 수행합니다.")
    @Test
    public void forEachJuestHasPrintln() {
        IntStream.range(1, 100)
                .filter(i -> i <= 50)
                // forEach 내부에 추가 연산이 없으며 최종 연산으로 출력만을 시행한다.
                .forEach(System.out::println);
    }

    @DisplayName("나쁜 케이스: forEach 는 필터링과 println 을 수행합니다.")
    @Test
    public void forEachHasInsideOperation() {
        // 100 번 반복함
        IntStream.range(1, 100).forEach(e -> {
            if ( e > 50 ) {
                return;
            }
            System.out.println(e);
        });
    }

}