package com.example.datastructures.model.tables;

import com.example.datastructures.model.list.IList;

/**
 * Interface representing a key-value table (similar to a map or dictionary).
 * Provides methods to set, retrieve, and manage key-value pairs in a table structure.
 *
 * @param <K> the type of keys maintained by this table
 * @param <V> the type of mapped values
 */
public interface ITable<K, V> {

    /**
     * Associates the specified value with the specified key in this table.
     * If the table previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    void set(final K key, final V value);

    /**
     * Returns the value to which the specified key is mapped, or null if this table contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if no mapping is found
     */
    V get(final K key);

    /**
     * Removes the mapping for the specified key from this table if present.
     *
     * @param key the key whose mapping is to be removed
     */
    void remove(final K key);

    /**
     * Removes all mappings from this table.
     */
    void clear();

    /**
     * Returns true if this table contains a mapping for the specified key.
     *
     * @param key the key whose presence in this table is to be tested
     * @return true if this table contains a mapping for the specified key, false otherwise
     */
    Boolean contains(final K key);

    /**
     * Returns true if this table contains no key-value mappings.
     *
     * @return true if this table contains no key-value mappings, false otherwise
     */
    Boolean isEmpty();

    /**
     * Returns the number of key-value mappings in this table.
     *
     * @return the number of key-value mappings
     */
    Integer size();

    /**
     * Returns a deep copy of this table.
     * The returned table is independent from the original one, meaning that changes to the copy do not affect the original table.
     *
     * @return a deep copy of this table
     */
    ITable<K, V> deepCopy();

    /**
     * Returns a list of the keys contained in this table.
     *
     * @return a list of the keys in this table
     */
    IList<K> keyList();
}
