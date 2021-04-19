package com.collection.gc.sample.spring;

import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import static org.junit.jupiter.api.Assertions.*;

class BeansUtilSample {

    @Test
    void copyProperties_copyValue_true() throws Exception {
        // given
        VegetableDto dto = VegetableDto.builder()
                                        .weight(10)
                                        .size(50)
                                        .name("양상추")
                                        .build();

        // when
        Vegetable vegetable = new Vegetable();
        BeanUtils.copyProperties(dto, vegetable);

        // then
        System.out.println( vegetable.toString() );
        System.out.println( dto.toString() );
        assertEquals(vegetable.getName(), dto.getName());
    }

    @Test
    void copyProperties_copyValueIgnore_false() throws Exception {
        // given
        VegetableDto dto = VegetableDto.builder()
                .weight(10)
                .size(50)
                .name("양상추")
                .build();

        // when
        Vegetable vegetable = new Vegetable();
        BeanUtils.copyProperties(dto, vegetable, "name");

        // then
        System.out.println( vegetable.toString() );
        System.out.println( dto.toString() );
        assertNotEquals(vegetable.getName(), dto.getName());
    }
}

/**
 * Target, 복사 대상 객체는 setter 가 열려있어야 한다.
 * - 접근제한 레벨 낮춰서 해봤는데 안됨 public 만 되는듯?
 */
@ToString
@NoArgsConstructor
@Setter
@Getter
class Vegetable {
    private int weight;
    private int size;
    private String name;
}

/**
 * Source, 원본 객체는 getter 가 열려있어야 한다.
 */
@ToString
@NoArgsConstructor
@Getter
class VegetableDto {
    private int weight;
    private int size;
    private String name;

    @Builder
    public VegetableDto(int weight, int size, String name) {
        this.weight = weight;
        this.size = size;
        this.name = name;
    }
}