package org.hwmoodle;

public class MyHashMap<T, Y> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<T, Y>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private static class Node<T, Y> {
        final T key;
        Y value;
        Node<T, Y> next;

        Node(T key, Y value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(T key, Y value) {
        int index = getBucketIndex(key);
        Node<T, Y> node = buckets[index];

        while (node != null) {
            if (node.key != null && node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<T, Y> newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public Y get(T key) {
        int index = getBucketIndex(key);
        Node<T, Y> node = buckets[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public boolean containsKey(T key) {
        int index = getBucketIndex(key);
        Node<T, Y> node = buckets[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(T key) {
        return key.hashCode() % buckets.length;
    }
}
