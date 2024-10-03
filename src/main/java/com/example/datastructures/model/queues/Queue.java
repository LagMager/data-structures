package com.example.datastructures.model.queues;

/**
 * A generic queue implementation using a circular array.
 *
 * @param <T> the type of elements in this queue
 */
public class Queue<T> implements IQueue<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    /**
     * Constructs an empty queue with initial capacity.
     */
    public Queue() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    @Override
    public void enqueue(final T elem) {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newQueue = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newQueue[i] = elements[(front + i) % elements.length];
            }
            elements = newQueue;
            front = 0;
            rear = size - 1;
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = elem;
        size++;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            return;
        }
        front = (front + 1) % elements.length;
        size--;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[front];
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
    public IQueue<T> deepCopy() {
        IQueue<T> copy = new Queue<>();
        for (int i = 0; i < size; i++) {
            copy.enqueue((T) elements[(front + i) % elements.length]);
        }
        return copy;
    }

}
