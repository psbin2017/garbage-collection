package com.collection.gc.sample;

import java.util.List;

import lombok.Getter;

/**
 * https://woowacourse.github.io/javable/2020-05-18/inheritance-vs-composition
 */
public class CompositionSample {
    // 생략
}

class Gun {
    private List<Integer> ammo;

    public Gun(List<Integer> ammo) {
        this.ammo = ammo;
    }

    public void add(Integer bullet) {
        ammo.add(bullet);
    }
}

/**
 * bullet 은 상위 클래스를 의존하고 있다.
 * 상위 클래스에서의 bullet 의 변화는 곧 하위 클래스에 변화를 가져 유연하지 못한 상속으로 이어진다.
 * 
 * + 상속은 코드의 재사용의 관점보다는 확장이라는 관점으로 봐야한다.
 */
class MachineGun extends Gun {

    @Getter
    private Scope scope;

    public MachineGun(List<Integer> bullet, Scope scope) {
        super(bullet);
        this.scope = scope;
    }

}

/**
 * 조합하여 사용하기 때문에 Gun 객체의 변화와 관계가 없어진다.
 */
class CompositionMachineGun {

    @Getter
    private Gun gun;

    @Getter
    private Scope scope;
}

class Scope {
    // 생략
}