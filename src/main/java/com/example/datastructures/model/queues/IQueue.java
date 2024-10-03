package com.example.datastructures.model.queues;

public interface IQueue<T> {
    void enqueue(final T elem);
    void dequeue();
    T front();
    Boolean isEmpty();
    Integer size();
    IQueue<T> deepCopy();
}
