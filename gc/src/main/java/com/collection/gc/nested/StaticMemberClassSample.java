package com.collection.gc.nested;

/**
 * 정적 멤버 클래스
 * - 멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static 을 붙여 정적 멤버 클래스로 만들자.
 *
 * public : 도우미 클래스, 특정 문맥에 의미를 가지는 클래스
 * private : 바깥 클래스의 요소
 */
public class StaticMemberClassSample {

    private static int staticNumber;
    private int nonStaticNumber;

    public static class StaticMemberClass {
        public void act() {
            // 바깥 정적 멤버에 접근 가능
            staticNumber = 1;

            // 다른 정적 멤버 클래스에 접근 가능
            StaticMemberEnum staticMemberEnum = StaticMemberEnum.PLUS;
        }
    }

    /*
     * enum = static class
     */
    private enum StaticMemberEnum {
        PLUS
    }
}