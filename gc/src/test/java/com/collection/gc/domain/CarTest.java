package com.collection.gc.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.collection.gc.domain.car.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;

/**
 * https://woowacourse.github.io/javable/2020-04-28/ask-instead-of-getter
 */
public class CarTest {


    @DisplayName("람보르기니가 단독으로 우승합니다!!")
    @Test
    public void refactoringFindWinners_Position7Winner_Single() {

        List<Car> carList = new ArrayList<Car>();
        carList.add( new Car("SM5", 5, LightStatus.ON) );
        carList.add( new Car("페라리", 3, LightStatus.BROKEN) );
        carList.add( new Car("테슬라", 6, LightStatus.UNKNOWN) );
        carList.add( new Car("람보르기니", 7, LightStatus.ON) );
        carList.add( new Car("부가티", 6, LightStatus.OFF) );
        carList.add( new Car("K7", 6, LightStatus.OFF) );

        Cars cars = new Cars(carList);

        List<String> actual = new ArrayList<String>();
        actual.add( "람보르기니" );
        assertEquals( actual , cars.refactoringFindWinners());
    }

    @DisplayName("페라리와 포드가 동시에 들어옵니다!!")
    @Test
    public void refactoringFindWinners_Position8Winners_Pair() {

        List<Car> carList = new ArrayList<Car>();
        carList.add( new Car("SM5", 5, LightStatus.ON) );
        carList.add( new Car("페라리", 8, LightStatus.BROKEN) );
        carList.add( new Car("포드", 8, LightStatus.UNKNOWN) );
        carList.add( new Car("람보르기니", 7, LightStatus.ON) );
        carList.add( new Car("부가티", 6, LightStatus.OFF) );
        carList.add( new Car("K7", 6, LightStatus.OFF) );

        Cars cars = new Cars(carList);

        List<String> actual = new ArrayList<String>();
        actual.add( "페라리" );
        actual.add( "포드" );
        assertEquals( actual , cars.refactoringFindWinners());
    }

    @DisplayName("차량 리스트가 비었습니다.")
    @Test
    public void refactoringFindWinners_CarIsEmpty_ExceptionThrown() {
        List<Car> carList = new ArrayList<Car>();
        Cars cars = new Cars(carList);
        assertThrows(IllegalArgumentException.class, () -> cars.refactoringFindWinners() );
    }

}

@AllArgsConstructor
class Cars {

    private List<Car> cars;

    // 순수한 조회 용도로 사용하는 객체
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> findWinners() {
        final int maximum = cars.stream()
                                .map(car -> car.getPosition()) // getter 를 통해 직접 값을 꺼내서 비교한다.
                                .max(Integer::compareTo)
                                .get();

        return cars.stream()
                    .filter(car -> car.getPosition() == maximum)
                    .map(Car::getName)
                    .collect(Collectors.toList());
    }

    public List<String> refactoringFindWinners() {
        final Car maxPositionCar = findMaxPositionCar();
        return findSamePositionCar(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                    .max(Car::compareTo)
                    .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다.") );
    }

    private List<String> findSamePositionCar(final Car maxPositionCar) {
        return cars.stream()
                    .filter(maxPositionCar::isSamePosition)
                    .map(Car::getName)
                    .collect(Collectors.toList());
    }

}