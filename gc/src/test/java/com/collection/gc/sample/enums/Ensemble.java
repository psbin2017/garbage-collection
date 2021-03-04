package com.collection.gc.sample.enums;

public enum Ensemble {
    // 명시적인 순서 인스턴스 필드 사용
    SOLO(1),
    DUET(2),
    TRIO(3),
    QUARTET(4),
    QUINTET(5),
    SEXTET(6),
    SEPTET(7),
    OCTET(8),
    DOUBLE_QUARTET(8),
    NONET(9),
    DECTET(10),
    TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int getNumberOfMusicians() {
        return numberOfMusicians;
    }
}
