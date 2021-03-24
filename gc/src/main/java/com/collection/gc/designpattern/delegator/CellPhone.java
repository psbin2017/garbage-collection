package com.collection.gc.designpattern.delegator;

/**
 * 위임 패턴
 *
 * 응용
 * @See com.collection.gc.sample.interfaces.FishBreadMachine
 *
 * 1. 위임 객체에 요청(메소드)이 들어오면,
 * 2. 실제 요청을 처리하는 객체에게 요청을 알림
 */
public class CellPhone {

    public void call() {
        Carrier carrier = new Carrier();
        carrier.call();
    }

}
