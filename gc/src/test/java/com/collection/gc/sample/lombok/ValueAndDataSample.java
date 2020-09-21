package com.collection.gc.sample.lombok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.NonFinal;

public class ValueAndDataSample {
    
    @DisplayName("@Data 자바빈즈 객체, NoArgsConstructor")
    @Test
    public void lombokData_DataNoArgsConstructor_SetEnabled() {
        DataAnnontation noArgsConstructor = new DataAnnontation();
        noArgsConstructor.setName("아무개");

        String actual = "아무개";
        assertEquals( noArgsConstructor.getName(), actual);
    }

    @DisplayName("@Data 자바빈즈 객체, RequiredArgsConstructor 를 통한 @NonNull 멤버 변수 생성자")
    @Test
    public void lombokData_DataRequiredArgsConstructor_SetEnabled() {
        DataAnnontation requiredArgsConstructor = new DataAnnontation("아무개");
        requiredArgsConstructor.setName("홍길동");

        String actual = "홍길동";
        assertEquals( requiredArgsConstructor.getName(), actual);
    }

    @DisplayName("@Value 불변 객체로 생성, @NonFinal 을 통한 불변 대상 제외")
    @Test
    public void lombokValue_ValueNonFinal_SetEnabled() {
        ValueAnnontation allArgsConstructor = new ValueAnnontation("라이언", 20);

        // @NonFinal 로 변경이 불변 대상에서 제외
        allArgsConstructor.setName("어피치");

        String actual = "어피치";
        assertEquals( allArgsConstructor.getName() , actual);
    }

}

@Data
@NoArgsConstructor
@RequiredArgsConstructor
class DataAnnontation {
    @NonNull String name;
    private int score;
}

@Value
class ValueAnnontation {
    @Setter @NonFinal private String name;
    private int score;
}
