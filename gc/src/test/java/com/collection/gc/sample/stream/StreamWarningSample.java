package com.collection.gc.sample.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://hamait.tistory.com/547
 */
public class StreamWarningSample {
    
    @DisplayName("주의사항 1. 스트림은 재사용 할 수 없다.")
    @Test
    public void streamNonReusable() {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
        stream.forEach(System.out::println);
        // java.lang.IllegalStateException: stream has already been operated upon or closed
        // stream.forEach(System.out::println);
    }

    @DisplayName("주의사항 2. 무한 스트림")
    @Test
    public void streamInfinity() {
        IntStream.iterate(0, i -> i + 1)
                // .skip(5)
                .limit(10) // limit 가 생략시 무한 반복이 뙇
                // .skip(5)
                .forEach(System.out::println);

        IntStream.iterate(0, i -> (i + 1) % 2 )
                .parallel() // parallel 은 반복을 증폭(?) 시키는 상황을 야기함
                .limit(10) // distinct 와 순서가 바뀌면 무한 반복이 뙇
                .distinct()
                .forEach(System.out::println);
    }

    @DisplayName("주의사항 3. 파일 시스템 walking")
    @Test
    public void streamWalking() {
        try {
            Files.walk(Paths.get("."))
                    // 전체 디렉토리를 포함하여 서브 디렉토리까지 스트림이 생산됨. 
                    .filter(p -> ! p.toFile().getName().startsWith(".") )
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.print( e.getMessage() );
        }
    }

    @DisplayName("주의사항 4. 리스트 순회 과정에서 리스트를 수정해선 안된다.")
    @Test
    public void streamBackingCollection() {
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        // 원하는 순회가 진행되었지만 이후에 소비하였기 때문에 리스트가 비어있다.
        list.stream()
            .sorted()
            // .parallel() // 병렬로 열면 순서가 보장이 안됨 + 리스트가 비어있지도 않음
            .peek(list::remove)
            .forEach(System.out::println);
    }

    @DisplayName("주의사항 5. 스트림을 소비하는 것을 까먹었다.")
    @Test
    public void streamForgotConsume() {
        IntStream.range(1, 5)
            .peek(System.out::println)
            .peek(i -> {
                if ( i == 5 ) {
                    throw new RuntimeException("BAMM");
                }
            });
    }

    @DisplayName("주의사항 6. 병렬 스트림의 데드락")
    @Test
    public void parallelStreamDeadlock() {
        Object[] locks = { new Object(), new Object() };
 
        IntStream
            .range(1, 5)
            // .parallel() // 병렬로 실행시 각 스레드가 synchronized 진입 후 다음 synchronized 진입을 위해 무한정으로 대기한다.
            .peek(i -> {
                synchronized (locks[i % locks.length]) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.out.println( "Outer Exception :: " + e.getMessage() );
                    }
                    synchronized (locks[(i + 1) % locks.length]) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            System.out.println( "Inner Exception :: " + e.getMessage() );
                        }
                    }
                }
            })
            .forEach(System.out::println);
    }

}