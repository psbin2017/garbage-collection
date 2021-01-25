package com.collection.gc.sample.interfaces;

public interface FishBreadMachine {
    void start();
    void rolling();
    void stop();
    void process();
}

class CreamService {
    public void mixedAdditive() {
        System.out.println("Mixed nothing");
    }
}

abstract class AbstractFishBreadMachine implements FishBreadMachine {
    @Override
    public void start() {
        System.out.println("Start Fish Bread Machine");
    }

    @Override
    public void stop() {
        System.out.println("Stop Fish Bread Machine");
    }

    @Override
    public void process() {
        start();
        rolling();
        stop();
    }
}

/**
 * delegate pattern
 * 인터페이스의 공통 구현 부분을 추상 클래스에 담고, 남은 구현체를 private Delegator 에 담아 구현한다.
 * 그리고 실 구현은 위임한다.
 */
class RedBeanFishBreadMachine implements FishBreadMachine {

    private class AbstractFishBreadMachineDelegator extends AbstractFishBreadMachine {
        @Override
        public void rolling() {
            System.out.println("Rolling Red Bean Fish");
        }
    }

    AbstractFishBreadMachineDelegator delegator = new AbstractFishBreadMachineDelegator();

    @Override
    public void start() {
        delegator.start();
    }

    @Override
    public void rolling() {
        delegator.rolling();
    }

    @Override
    public void stop() {
        delegator.stop();
    }

    @Override
    public void process() {
        delegator.process();
    }

}

class ChouCreamFishBreadMachine extends CreamService implements FishBreadMachine {
    
    private class AbstractFishBreadMachineDelegator extends AbstractFishBreadMachine {
        @Override
        public void rolling() {
            System.out.println("Rolling Chou Cream Fish");
        }
    }

    AbstractFishBreadMachineDelegator delegator = new AbstractFishBreadMachineDelegator();

    @Override
    public void start() {
        delegator.start();
    }

    @Override
    public void rolling() {
        delegator.rolling();
    }

    @Override
    public void stop() {
        delegator.stop();
    }

    @Override
    public void process() {
        delegator.process();
    }

    @Override
    public void mixedAdditive() {
        // 위임 대상이 아닌 내용은 직접 구현
        System.out.println("Mixed Custard");
    }
}

class FishBreadMachineManager {
    public static void main(String[] args) {
        FishBreadMachine redBean = new RedBeanFishBreadMachine();
        FishBreadMachine chouCream = new ChouCreamFishBreadMachine();

        redBean.rolling();
        chouCream.rolling();

        if ( chouCream instanceof CreamService ) {
            CreamService creamService = (CreamService) chouCream;
            creamService.mixedAdditive();
        }
    }

}