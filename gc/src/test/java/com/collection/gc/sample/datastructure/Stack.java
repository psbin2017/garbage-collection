package com.collection.gc.sample.datastructure;

import java.util.NoSuchElementException;

/**
 * Last In First Out
 *
 * 1. 맨 위에 추가한다.
 * 2. 맨 위에 있는거 꺼낸다.
 * 3. 맨 위에 있는지 확인한다.
 * 4. 비어있는지 확인한다.
 */
public class Stack<T> {

    private Node<T> top;

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 맨 위에 올리기
     */
    public void push(T item) {
        Node<T> node = new Node<>(item);

        // 새로 위에 있는 다음 값을 원래 위에 있는 것을 바라보게함
        node.next = top;

        // 맨 위에 있던거 아래로 내림
        top = node;
    }

    /**
     * 맨 위에 있는 거 꺼내기
     */
    public T pop() {
        if ( top == null ) {
            throw new NoSuchElementException("");
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    /**
     * 맨 위에 있는 거 확인하기
     */
    public T peek() {
        if ( top == null ) {
            throw new NoSuchElementException("");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
