package com.collection.gc.sample.sync;

import java.util.*;

public class ObservableSet<E> extends FowardingSet<E> {
    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added) {
            notifyElementAdded(e);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element); // result = result | add(element);
        }
        return result;
    }

    private void notifyElementAdded(E e) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, e);
            }
        }
    }

    public static void main(String[] args) {
//        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
//        set.addObserver((s, e) -> System.out.println(e));
//        for (int i = 0; i < 100; i ++) {
//            set.add(i);
//        }


        // 1. added 메소드 호출이 일어난 시점이 notifyElementAdded 가 관찰자들의 리스트를 순화하는 도중에 일어난다.
        // 2. added 메소드는 ObservableSet 의 removeObserver 를 호출하고,
        // 3. 해당 메소드는 다시 observers.remove 메소드를 호출한다.
        // --> 리스트에서 원소를 제거하려 하는데, 마침 리스트를 순회하는 도중이다.
        // --> notifyElementAdded 메소드에서 수행하는 순회는 동기화 블록 안이므로 동시 수정이 일어나지 않도록 보장하지만,
        // --> 정작 자신이 콜백을 거쳐 되돌아와서 수정하는 것을 막지 못하였다.
        ObservableSet<Integer> set2 = new ObservableSet<>(new HashSet<>());
        set2.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if ( element == 23) {
                    set.removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i ++) {
            set2.add(i);
        }
    }
}

@FunctionalInterface interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}