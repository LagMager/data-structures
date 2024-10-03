package com.example.datastructures.model.queues;

/**
 * Interface for a generic queue data structure.
 *
 * @param <T> the type of elements in this queue
 */
public interface IQueue<T> {
    /**
     * Adds an element to the end of the queue.
     *
     * @param elem the element to be added
     */
    void enqueue(final T elem);
    /**
     * Removes the element at the front of the queue.
     */
    void dequeue();
    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     *
     * @return the front element of the queue, or {@code null} if the queue is empty
     */
    T front();
    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    Boolean isEmpty();
    /**
     * Gets the number of elements in the queue.
     *
     * @return the size of the queue
     */
    Integer size();
    /**
     * Creates a deep copy of the queue.
     *
     * @return a new queue that is a deep copy of this queue
     */
    IQueue<T> deepCopy();
}
