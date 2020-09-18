package com.collection.gc.domain.primitive;

import org.springframework.util.StringUtils;

public class Name {
    private String name;

    public Name(String name) {
        if ( StringUtils.isEmpty(name) ) {
            throw new RuntimeException("이름은 공백일 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}