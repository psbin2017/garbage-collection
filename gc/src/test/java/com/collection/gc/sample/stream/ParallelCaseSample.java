package com.collection.gc.sample.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelCaseSample {

    public static long piParallel(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                // .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    @DisplayName("21초")
    @Test
    public void testPiNonParallel() throws Exception {
        // given
        StopWatch st = new StopWatch("non parallel");

        // when
        st.start();
        long n = pi(10000000L);
        st.stop();

        // then
        System.out.println( st.getTotalTimeSeconds() + " seconds" );
    }

    @DisplayName("4초")
    @Test
    public void testPiParallel() throws Exception {
        // given
        StopWatch st = new StopWatch("non parallel");

        // when
        st.start();
        long n = piParallel(10000000L);
        st.stop();

        // then
        System.out.println( st.getTotalTimeSeconds() + " seconds" );
    }
}
