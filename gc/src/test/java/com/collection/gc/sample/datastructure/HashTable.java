package com.collection.gc.sample.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 해시 테이블
 *
 * 테이블 생성
 * 1. 받은 인자 값 만큼 링크드 리스트 배열 생성.
 *
 * LinkedList [0]
 * LinkedList [1]
 * LinkedList [2]
 *
 * 데이터 추가
 * 1. 받은 키로 해시 코드 변환 (아스키 값으로 변환)
 * 2. 생성한 해시코드로 인덱스 변환 (초기화 시점에 생성한 링크드 리스트 배열 사이즈 만큼 해시코드를 나눔)
 * 3. 링크드 리스트에 추가
 *
 * 데이터 가져오기
 * 1. 받은 키로 해시 코드 변환 (아스키 값으로 변환)
 * 2. 생성한 해시코드로 인덱스 변환 (초기화 시점에 생성한 링크드 리스트 배열 사이즈 만큼 해시코드를 나눔)
 * 3. 링크드 리스트가 비어있으면 null
 * 4. 링크드 리스트의 키로 값을 노드를 찾고 없으면 null
 */
public class HashTable {

    public static class Node {
        private final String key;
        private Object value;

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }

    }

    public LinkedList<Node>[] table;

    public HashTable(int size) {
        table = new LinkedList[size];
    }

    private int hashCode(String key) {
        int hashCode = 0;
        for (char ch : key.toCharArray()) {
            hashCode += ch;
        }
        return hashCode;
    }

    private int convertHashcodeToIndex(int hashCode) {
        return hashCode % table.length;
    }

    public Node searchKey(LinkedList<Node> list, String key) {
        if ( list == null ) {
            return null;
        }

        // 노드의 키값과 키를 비교하여 일치하는 경우 해당 노드를 반환함
        for ( Node node: list ) {
            if ( node.key.equals(key) ) {
                return node;
            }
        }
        return null;
    }

    public void put(String key, Object value) {
        int hashCode = hashCode(key);
        int index = convertHashcodeToIndex(hashCode);
        LinkedList<Node> list = table[index];

        // 링크드 리스트가 없는 경우 새로 생성함
        if ( list == null ) {
            list = new LinkedList<>();
            table[index] = list;
        }

        // 이미 노드에 값이 있는지 색인, 없는 경우 추가
        Node node = searchKey(list, key);
        if ( node == null ) {
            list.addLast(new Node(key, value));
        } else {
            node.value = value;
        }
    }

    public Object get(String key) {
        int hashCode = hashCode(key);
        int index = convertHashcodeToIndex(hashCode);
        LinkedList<Node> list = table[index];

        // 노드 찾음
        Node node = searchKey(list, key);
        if ( node == null ) {
            return null;
        }
        return node.value;
    }
}

class HashCodeTest {

    @Test
    public void testPutAndGet() throws Exception {
        // given
        HashTable hashTable = new HashTable(5);

        // when
        hashTable.put("Hello", 1);
        hashTable.put("World", "2");

        // then
        Assertions.assertThat(hashTable.get("Hello")).isEqualTo(1);
        Assertions.assertThat(hashTable.get("World")).isEqualTo("2");
    }

    @Test
    public void testPutAndGet_changeValue() throws Exception {
        // given
        HashTable hashTable = new HashTable(5);

        // when
        hashTable.put("Hello World", 1);
        hashTable.put("World", 2);

        hashTable.put("Hello World", 3);

        // then
        Assertions.assertThat(hashTable.get("Hello World")).isNotEqualTo(1);
    }
}