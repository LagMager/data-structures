package com.example.datastructures.model.tables;

import com.example.datastructures.model.list.IList;
import com.example.datastructures.model.list.LinkedList;

/**
 * Implementation of a table (or map-like) data structure using two lists: one for keys and another for values.
 * It allows key-value pairs to be stored, retrieved, and managed.
 *
 * @param <K> the type of keys maintained by this table
 * @param <V> the type of mapped values
 */
public class Table<K, V> implements ITable<K, V> {
    private IList<K> keys;
    private IList<V> values;

    /**
     * Constructs an empty table.
     * Initializes two empty linked lists for storing keys and values.
     */
    public Table() {
        keys = new LinkedList<>();
        values = new LinkedList<>();
    }

    /**
     * Associates the specified value with the specified key in this table.
     * If the key already exists, the corresponding value is updated.
     * Otherwise, a new key-value pair is added.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    @Override
    public void set(K key, V value) {
        // If the key exists, update the value; otherwise, add a new key-value pair
        if (contains(key)) {
            int index = keys.indexOf(key);
            values.set(index, value);
        } else {
            keys.addLast(key);
            values.addLast(value);
        }
    }

    /**
     * Returns the value associated with the specified key, or null if the key is not present in the table.
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the specified key, or null if no mapping exists
     */
    @Override
    public V get(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            return values.get(index);
        }
        return null;
    }

    /**
     * Removes the mapping for the specified key from the table, if present.
     *
     * @param key the key whose mapping is to be removed
     */
    @Override
    public void remove(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            keys.removeElementByIndex(index);
            values.removeElementByIndex(index);
        }
    }

    /**
     * Removes all key-value mappings from this table.
     */
    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    /**
     * Returns true if this table contains a mapping for the specified key.
     *
     * @param key the key whose presence is to be tested
     * @return true if the key is present, false otherwise
     */
    @Override
    public Boolean contains(K key) {
        return keys.contains(key);
    }

    /**
     * Returns true if this table contains no key-value mappings.
     *
     * @return true if the table is empty, false otherwise
     */
    @Override
    public Boolean isEmpty() {
        return keys.isEmpty();
    }

    /**
     * Returns the number of key-value mappings in this table.
     *
     * @return the number of key-value mappings
     */
    @Override
    public Integer size() {
        return keys.size();
    }

    /**
     * Creates and returns a deep copy of this table.
     * The copy is independent, meaning changes to the copy do not affect the original table.
     *
     * @return a deep copy of this table
     */
    @Override
    public ITable<K, V> deepCopy() {
        Table<K, V> copy = new Table<>();
        for (int i = 0; i < keys.size(); i++) {
            copy.set(keys.get(i), values.get(i));
        }
        return copy;
    }

    /**
     * Returns a deep copy of the list of keys contained in this table.
     *
     * @return a deep copy of the key list
     */
    @Override
    public IList<K> keyList() {
        return keys.deepCopy();
    }
}
