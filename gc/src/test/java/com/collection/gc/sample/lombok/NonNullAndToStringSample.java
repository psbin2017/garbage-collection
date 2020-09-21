package com.collection.gc.sample.lombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

public class NonNullAndToStringSample {
    
    @DisplayName("@NonNull this() 또는 super() 호출 직후에 Null-Check")
    @Test
    public void lombokNonNull_NullString_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Dog(null));
    }

    @DisplayName("@ToString.Exclude toString() 시 예외로 나타나지 않는다.")
    @Test
    public void lombokToString_ToStringExclude_ExcludeTag() {
        Dog dog = new Dog("멍멍이", "1번");
        String actual = "Dog(name=멍멍이)";
        assertEquals( dog.toString() , actual );
    }

}

@ToString
class Dog {

    @Getter
    private String name;

    @ToString.Exclude String tag;

    public Dog(@NonNull String name) {
        this.name = name;
    }

    public Dog(@NonNull String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

}