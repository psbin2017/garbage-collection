package com.collection.gc.sample.lombok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

public class BuilderSample {
    
    @DisplayName("@Builder 비상속 객체의 정적 팩토리 메소드 형태의 객체 생성")
    @Test
    public void lombokBuilder_SimpleBuilder_SingularSet() {
        Set<Integer> scores = new HashSet<>();
        scores.add(10);
        scores.add(20);

        SimpleBuilder sb = SimpleBuilder.builder()
                                        .name("콘")
                                        .scores(scores)
                                        .build();

        // Test Code 는 특별한 의미 없음
        assertEquals( sb.getScores() , scores );
    }

    @DisplayName("@SuperBuilder 상속 객체의 정적 팩토리 메소드 형태의 객체 생성")
    @Test
    public void lombokSuperBuilder_SuperBuilderChild_LongCreated() {
        SuperBuilderChild sc = SuperBuilderChild.builder()
                                                .grade(5)
                                                .floor(10)
                                                .groupName("장미반")
                                                .build();

        int actual = 5;
        // Test Code 는 특별한 의미 없음
        assertEquals( sc.getGrade() , actual );
    }
}


@Getter
@Builder
class SimpleBuilder {
    private String name;
    @Singular Set<Integer> scores;
}

/**
 * 부모 클래스에도 @SuperBuilder 가 있어야 한다.
 */
@Getter
@SuperBuilder
class SuperBuilderParent {
    private int grade;
    private int floor;
}

/**
 * @Builder 로 선언 불가능 마찬가지로 @SuperBuilder 로 선언
 */
@Getter
@SuperBuilder
class SuperBuilderChild extends SuperBuilderParent {
    // 값이 설정되지 않았다면 생성 시점에 기본값으로 가져간다.
    @Builder.Default private long created = System.currentTimeMillis();
    private String groupName;
}