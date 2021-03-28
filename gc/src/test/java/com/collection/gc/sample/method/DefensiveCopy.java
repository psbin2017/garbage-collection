package com.collection.gc.sample.method;

import java.util.Date;

public class DefensiveCopy {
    private final Date start;
    private final Date end;

    /**
     * 원본 객체의 유효성을 검사한 후 복사본을 만드는 찰나에 취약한 순간 다른 스레드가 객체를 수정할 수 있기 때문에 방어적 복사 > 매개변수 유효성 검사 순으로 수행한다.
     *
     * 매개변수가 제 3자에 의해 확장될 수 있는 타입인 경우 방어적 복사본을 만들때 clone 을 사용해선 안된다.
     */
    public DefensiveCopy(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if ( this.start.compareTo(this.end) > 0 ) {
            throw new IllegalArgumentException(this.start + " after " + this.end);
        }
    }

    /**
     * 가변 필드에 대한 필드의 방어적 복사본을 반환한다.
     * 생성자와 달리 방어적 복사에 clone 을 사용해도 된다.
     * 내부에서 가지고 있던 필드는 java.util.Date 임을 보증하기 때문이다.
     */

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return (Date) end.clone();
    }
}
