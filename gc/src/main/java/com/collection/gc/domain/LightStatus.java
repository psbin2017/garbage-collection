package com.collection.gc.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LightStatus {
    
    OFF("조명 꺼짐"),
    ON("조명 켜짐"),
    BROKEN("조명 고장"),
    UNKNOWN("알 수 없음");

    private String description;

    private static final Map<String, LightStatus> descriptions = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(LightStatus::getDescription, Function.identity())));

    public static LightStatus find(final String description) {
        return Optional.ofNullable(descriptions.get(description)).orElse(UNKNOWN);
    }

}