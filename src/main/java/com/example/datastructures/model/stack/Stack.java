package com.example.datastructures.model.stack;

public class Stack<T> implements IStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public Stack() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public void push(final T elem) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size++] = elem;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            return;
        }
        elements[--size] = null; // Remove the reference to avoid memory leak
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[size - 1];
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
    public IStack<T> deepCopy() {
        Stack<T> copy = new Stack<>();
        for (int i = 0; i < size; i++) {
            copy.push((T) elements[i]);
        }
        return copy;
    }
}