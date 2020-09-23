package com.collection.gc.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * https://woowacourse.github.io/javable/2020-07-16/reflection-api
 * https://codechacha.com/ko/reflection/
 */
public class ReflectionAPISample {

    @DisplayName("Reflection API : constructor.newInstance")
    @Test
    public void ObjectReflectAPI_NewInstance_GetFuel() {

        int result = 0;
        try {
            Class<Car> carClass = Car.class;
            Constructor<Car> constructor = carClass.getDeclaredConstructor(int.class, int.class);

            Car car = constructor.newInstance(10, 5);
            result = car.getFuel();
        } catch (Exception e) {
            System.out.println( "Exception : " +  e.getMessage() );
        }
        int expected = 5;
        assertEquals(expected, result);
    }
    
    @DisplayName("Reflection API : method.invoke")
    @Test
    public void ObjectReflectionAPI_InvokeMethod_GetLocation() {
        Object car = new Car(0, 10);

        int result = 0;
        try {
            Class<Car> carClass = Car.class;
            Method move = carClass.getMethod("move");
            move.invoke(car, (Class<?>) null);

            Method getLocation = carClass.getMethod("getLocation");
            result = (int) getLocation.invoke(car, (Class<?>) null);
        } catch (Exception e) {
            System.out.println( "Exception : " +  e.getMessage() );
        }
        int expected = 1;
        assertEquals(expected, result);
    }

}

@Getter
@AllArgsConstructor
class Car {
    private int location;
    private int fuel;

    public void move() {
        if ( fuel < 0 ) {
            throw new RuntimeException("기름이 다했습니다.");
        }
        location++;
        fuel--;
    }
}