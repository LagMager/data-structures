package com.example.datastructures.model.stack;

/**
 * Interface for a generic stack data structure.
 *
 * @param <T> the type of elements in this stack
 */
public interface IStack<T> {
    /**
     * Pushes an element onto the stack.
     *
     * @param elem the element to be pushed
     */
    void push(final T elem);
    /**
     * Removes the element on top of the stack.
     */
    void pop();
    /**
     * Retrieves, but does not remove, the element on top of the stack.
     *
     * @return the top element of the stack, or {@code null} if the stack is empty
     */
    T peek();
    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    Boolean isEmpty();
    /**
     * Gets the number of elements in the stack.
     *
     * @return the size of the stack
     */
    Integer size();
    /**
     * Creates a deep copy of the stack.
     *
     * @return a new stack that is a deep copy of this stack
     */
    IStack<T> deepCopy();
}
