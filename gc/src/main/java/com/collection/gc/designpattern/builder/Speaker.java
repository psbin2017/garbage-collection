package com.collection.gc.designpattern.builder;

/**
 * 빌더 패턴 실습
 *
 * 1. 생성자를 제한
 * 2. 내부에 빌더 클래스 생성
 * 3. build() 로 생성자 호출
 */
public class Speaker {

    private String name;

    private boolean button;

    private long volume;

    public class Builder {
        private String name;
        private boolean button;
        private long volume;

        /**
         * 필수 인자는 생성자에 포함시킬 수 있음.
         */
        public Builder(long volume) {
            this.volume = volume;
        }

        public Builder button(boolean button) {
            this.button = button;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Speaker build() {
            return new Speaker(this);
        }
    }

    private Speaker(Builder builder) {
        this.name = builder.name;
        this.button = builder.button;
        this.volume = builder.volume;
    }
}
