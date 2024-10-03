package com.example.datastructures.model.dequeue;

import java.util.NoSuchElementException;

public class Dequeue<T> implements IDequeue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    @Override
    public void addFirst(T elem) {
        Node<T> newNode = new Node<>(elem);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T elem) {
        Node<T> newNode = new Node<>(elem);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        return tail.data;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // If head becomes null, tail should also be null
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty");
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // If tail becomes null, head should also be null
        }
        size--;
    }

    @Override
    public Boolean contains(T elem) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(elem)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public IDequeue<T> deepCopy() {
        Dequeue<T> copy = new Dequeue<>();
        Node<T> current = head;
        while (current != null) {
            copy.addLast(current.data);
            current = current.next;
        }
        return copy;
    }
}

