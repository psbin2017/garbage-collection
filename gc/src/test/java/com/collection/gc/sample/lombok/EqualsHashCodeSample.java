package com.collection.gc.sample.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualsHashCodeSample {

    @DisplayName("롬복 : equals 일반 객체")
    @Test
    public void lombokEqualsAndHashCode_EqualsCoffee_True() {
        Coffee coffeeA = new Coffee(100, 50);
        Coffee coffeeB = new Coffee(100, 50);
        assertTrue( coffeeA.equals( coffeeB )  );
    }

    @DisplayName("롬복 : hashCode 일반 객체")
    @Test
    public void lombokEqualsAndHashCode_HashCodeCoffee_True() {
        Coffee coffeeA = new Coffee(70, 10);
        Coffee coffeeB = new Coffee(70, 10);
        assertTrue( coffeeA.hashCode() == coffeeB.hashCode()  );
    }

    @DisplayName("롬복 : equals 상속 객체 + CallSuper true ")
    @Test
    public void lombokCallSuperTrue_EqualsCafeMocha_True() {
        CafeMocha coffeeA = new CafeMocha(160, 20, "카카오100");
        CafeMocha coffeeB = new CafeMocha(160, 20, "카카오100");
        assertTrue( coffeeA.equals( coffeeB )  );
    }

    @DisplayName("롬복 : hashCode 상속 객체 + CallSuper true ")
    @Test
    public void lombokCallSuperTrue_HashCodeCafeMocha_True() {
        CafeMocha coffeeA = new CafeMocha(310, 45, "가나");
        CafeMocha coffeeB = new CafeMocha(310, 45, "가나");
        assertTrue( coffeeA.hashCode() == coffeeB.hashCode()  );
    }

    @DisplayName("롬복 : equals 상속 객체 + CallSuper false ")
    @Test
    public void lombokCallSuperFalse_EqualsCafeLatte_True() {
        CafeLatte coffeeA = new CafeLatte(250, 30, "농협 우유");
        CafeLatte coffeeB = new CafeLatte(280, 50, "농협 우유");
        assertTrue( coffeeA.equals( coffeeB )  );
    }

    @DisplayName("롬복 : hashCode 상속 객체 + CallSuper false ")
    @Test
    public void lombokCallSuperFalse_HashCodeCafeLatte_True() {
        CafeLatte coffeeA = new CafeLatte(250, 30, "건국 우유");
        CafeLatte coffeeB = new CafeLatte(280, 50, "건국 우유");
        assertTrue( coffeeA.hashCode() == coffeeB.hashCode()  );
    }

}

@Getter
@AllArgsConstructor
@EqualsAndHashCode
class Coffee {
    private int water;
    private int sugar;
}

@EqualsAndHashCode(callSuper = true)
class CafeMocha extends Coffee {
    private String chocolate;

    public CafeMocha(int water, int sugar, String chocolate) {
        super(water, sugar);
        this.chocolate = chocolate;
    }
}

@EqualsAndHashCode(callSuper = false)
class CafeLatte extends Coffee {
    private String milk;

    public CafeLatte(int water, int sugar, String milk) {
        super(water, sugar);
        this.milk = milk;
    }
}