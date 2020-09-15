package com.collection.gc.domain.car;

import com.collection.gc.domain.LightStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Car implements Comparable<Car> {
    
    private String name;

    private int position;

    private LightStatus lightStatus;

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

}