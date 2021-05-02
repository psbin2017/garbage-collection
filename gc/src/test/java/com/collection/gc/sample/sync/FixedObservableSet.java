package com.collection.gc.sample.sync;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class FixedObservableSet<E> extends FowardingSet<E> {
    public FixedObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(SetObserver<E> observer) {
        return observers.remove(observer);
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
        for (SetObserver<E> observer : observers) {
            observer.added(this, e);
        }
    }

    public static void main(String[] args) {
        FixedObservableSet<Integer> set = new FixedObservableSet<>(new HashSet<>());
        set.addObserver(new FixedObservableSet.SetObserver<Integer>() {
            @Override
            public void added(FixedObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if ( element == 23) {
                    set.removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i ++) {
            set.add(i);
        }
    }

    @FunctionalInterface interface SetObserver<E> {
        void added(FixedObservableSet<E> set, E element);
    }
}