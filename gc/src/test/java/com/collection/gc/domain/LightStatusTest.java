package com.collection.gc.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

public class LightStatusTest {
    
    /**
     * https://woowacourse.github.io/javable/2020-04-21/enum_search
     */
    @DisplayName("enum 해시맵 속도 테스트")
    @Test
    public void test1() {
        StopWatch sw = new StopWatch("해시맵 속도 테스트");
        sw.start("조명 꺼짐");
        for ( int i = 0; i < 100000000; i++ ) {
            LightStatus.find("조명 꺼짐");
        }
        sw.stop();
        sw.start("잘못된 요청");
        for ( int i = 0; i < 100000000; i++ ) {
            LightStatus.find("잘못된 요청");
        }
        sw.stop();
        System.out.println( sw.prettyPrint() );
    }

}