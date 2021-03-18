package com.collection.gc.nested;

/**
 * 비정적 멤버 클래스
 * - 비정적 멤버 클래스가 바깥 클래스에 참조를 가질 수 있다. (연결된다)
 * - 참조를 가질 필요가 없다면 꺼내거나 정적 멤버 클래스로 만들어라.
 */
public class NonStaticMemberClassSample {

    public void nonStatic() {
        System.out.println("todo");
    }

    public class NonStaticMemberClass {
        public NonStaticMemberClass() {
            // 외부 객체의 참조를 가질 수 있다. (바깥 객체와 연결된다)
            NonStaticMemberClassSample nonStaticMemberClass = NonStaticMemberClassSample.this;
            nonStaticMemberClass.nonStatic();
        }
    }
}
