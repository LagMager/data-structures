package com.example.datastructures.model.tables;


import com.example.datastructures.model.list.IList;
import com.example.datastructures.model.list.LinkedList;

public class Table<K, V> implements ITable<K, V> {
    private IList<K> keys;
    private IList<V> values;

    public Table() {
        keys = new LinkedList<>();
        values = new LinkedList<>();
    }

    @Override
    public void set(K key, V value) {
        // Si la clave ya existe, actualiza el valor
        if (contains(key)) {
            int index = keys.indexOf(key);
            values.set(index, value);
        } else { // Si no, añade una nueva entrada
            keys.addLast(key);
            values.addLast(value);
        }
    }

    @Override
    public V get(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            return values.get(index);
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            keys.removeElementByIndex(index);
            values.removeElementByIndex(index);
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Boolean contains(K key) {
        return keys.contains(key);
    }

    @Override
    public Boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public Integer size() {
        return keys.size();
    }

    @Override
    public ITable<K, V> deepCopy() {
        Table<K, V> copy = new Table<>();
        for (int i = 0; i < keys.size(); i++) {
            copy.set(keys.get(i), values.get(i));
        }
        return copy;
    }

    @Override
    public IList<K> keyList() {
        return keys.deepCopy();
    }
}

