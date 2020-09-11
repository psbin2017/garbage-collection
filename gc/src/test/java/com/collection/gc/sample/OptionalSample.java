package com.collection.gc.sample;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import lombok.Getter;
import lombok.ToString;

public class OptionalSample {
    
    /**
     * https://woowacourse.github.io/javable/2020-04-21/optional-vs-null
     */
    public OptionalInt findMinMultiple(List<Integer> numbers, int anyNumber) {
        return numbers.stream()
                    .sorted()
                    .filter(o -> o % anyNumber == 0)
                    .findFirst()
                    .map(OptionalInt::of)
                    // 이미 생성되었거나 계산된 값이 아니면 orElseGet 을 사용한다.
                    .orElseGet(OptionalInt::empty);
    }

    /**
     * https://cfdf.tistory.com/34
     */
    public void testCase() {

        // orElse 는 null 이던 말던 항상 불립니다.
        // orElseGet 은 null 일 때만 불립니다.

        String username = "이름";
        String result1 = Optional.ofNullable(username).orElse("no name");
        System.out.println(result1);

        String result2 = Optional.ofNullable(username).orElseGet(() -> "no name");
        System.out.println(result2);

    }

}

@ToString
@Getter
class Member {
    private int seq;
    private String name;
}