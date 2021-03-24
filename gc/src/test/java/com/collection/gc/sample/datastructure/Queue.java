package com.collection.gc.sample.datastructure;

import java.util.NoSuchElementException;

/**
 * First In First Out
 *
 * 1. 추가
 * 2. 꺼내기
 * 3. 확인하기
 * 4. 비어있는지 확인하기
 */
public class Queue<T> {

    private Node<T> first;
    private Node<T> last;

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 데이터 추가
     */
    public void add(T item) {
        Node<T> node = new Node<>(item);

        // 마지막 노드가 있는 경우
        // 마지막 노드에 연결함
        if ( this.last != null ) {
            last.next = node;
        }

        // 마지막 노드로 추가함
        this.last = node;

        // 첫번째 노드가 비어있는 경우 추가함
        if ( this.first == null ) {
            this.first = node;
        }
    }

    /**
     * 맨 앞에있는 데이터 꺼내기
     */
    public T remove() {
        if ( this.first == null ) {
            throw new NoSuchElementException("");
        }

        T data = first.data;
        first = first.next;
        if ( first == null ) {
            last = null;
        }
        return data;
    }

    /**
     * 맨 앞에있는 데이터 확인하기 (꺼내지 않는다.)
     */
    public T peek() {
        if ( this.first == null ) {
            throw new NoSuchElementException("");
        }
        return first.data;
    }

    /**
     * 비어있는지 확인
     */
    public boolean isEmpty() {
        return first == null;
    }
}
