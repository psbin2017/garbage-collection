package com.collection.gc.sample.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class LocalDateTimeTest {

    private final LocalTime TIME_07_29_59 = LocalTime.of(7, 29, 59);

    @DisplayName("현재 시간이 지정된 시간보다 이전/이후 인지 확인")
    @Test
    void test_LocalTimeIsBefore_LocalTimeIsAfter() throws Exception {
        // given
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalTime localTime = localDateTime.toLocalTime().withNano(0);

        // when
        boolean isBefore = localTime.isBefore(TIME_07_29_59);
        if ( isBefore ) {
            System.out.println(localTime.toString() + " : Time isBefore : " + TIME_07_29_59.toString());
        }

        boolean isAfter = localTime.isAfter(TIME_07_29_59);
        if ( isAfter ) {
            System.out.println(localTime.toString() + " : Time isAfter : " + TIME_07_29_59.toString());
        }

        Assertions.assertNotEquals(isBefore, isAfter);
    }

    @DisplayName("ChronoUnit 비교")
    @Test
    void test_ChronoUnit() throws Exception {
        // given
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime next_10_29_59 = localDateTime.plusDays(1L).withHour(10).withMinute(29).withSecond(59).withNano(0);

        // when
        long years = ChronoUnit.YEARS.between( localDateTime, next_10_29_59 );
        long months = ChronoUnit.MONTHS.between( localDateTime, next_10_29_59 );
        long weeks = ChronoUnit.WEEKS.between( localDateTime, next_10_29_59 );
        long days = ChronoUnit.DAYS.between( localDateTime, next_10_29_59 );
        long hours = ChronoUnit.HOURS.between( localDateTime, next_10_29_59 );
        long seconds = ChronoUnit.SECONDS.between( localDateTime, next_10_29_59 );
        long millis = ChronoUnit.MILLIS.between( localDateTime, next_10_29_59 );
        long nanos = ChronoUnit.NANOS.between( localDateTime, next_10_29_59 );

        // then
        System.out.println( "Years Diff " + years);
        System.out.println( "Months Diff " + months);
        System.out.println( "Weeks Diff " + weeks);
        System.out.println( "Days Diff " + days);
        System.out.println( "Hours Diff " + hours);
        System.out.println( "Seconds Diff " + seconds);
        System.out.println( "Millis Diff " + millis);
        System.out.println( "Nanos Diff " + nanos);

        Assertions.assertTrue( seconds > 0L );
    }

    @DisplayName("ChronoUnit 비교")
    @Test
    void test_Duration() throws Exception {
        // given
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime next_11_49_59 = localDateTime.minusDays(1L).withHour(11).withMinute(49).withSecond(59).withNano(0);

        // when
        Duration duration = Duration.between( localDateTime, next_11_49_59 );

        // then
        System.out.println( "Duration getSeconds " + duration.getSeconds());
        System.out.println( "Duration getNano  " + duration.getNano());

        Assertions.assertTrue( duration.getSeconds() < 0L );
    }

    @DisplayName("만료 시간 가져오기")
    @Test
    void test_getExpiredTime() throws Exception {
        // given
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalTime localTime = localDateTime.toLocalTime().withNano(0);

        // when
        String expiredTime;
        LocalDateTime diffDateTime;

        if ( localTime.isBefore(TIME_07_29_59) ) {
            diffDateTime = localDateTime
                    .withHour(TIME_07_29_59.getHour())
                    .withMinute(TIME_07_29_59.getMinute())
                    .withSecond(TIME_07_29_59.getSecond());
            System.out.println("is before");
        } else {
            diffDateTime = localDateTime
                    .plusDays(1L)
                    .withHour(TIME_07_29_59.getHour())
                    .withMinute(TIME_07_29_59.getMinute())
                    .withSecond(TIME_07_29_59.getSecond());
            System.out.println("is after");
        }
        expiredTime = Long.toString( ChronoUnit.SECONDS.between(localDateTime, diffDateTime) );

        // then
        System.out.println( "expiredTime : " + expiredTime );
        Assertions.assertTrue( Long.parseLong(expiredTime) > 0L );
    }
    
}
