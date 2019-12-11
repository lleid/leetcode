package com.leo.structure.array;

/**
 * 自定义数组
 */
public class IArray<T> {
    private Object data[];
    private int size;

    public IArray(int capacity) {
        this.data = new Object[capacity];
        this.size = capacity;
    }

    public IArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public boolean contains(T value) {
        for (int i = 0; i < data.length; i++) {
            if (data.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int find(T value) {
        for (int i = 0; i < data.length; i++) {
            if (data.equals(value)) {
                return i;
            }
        }
        return -1;
    }


    public void add(int index, T value) {
        checkIndexForOperate(index);
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    public T remove(int index) {
        checkIndex(index);

        T tmp = (T) data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return tmp;
    }


    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void resize(int capacity) {
        Object[] objects = new Object[capacity];
        for (int i = 0; i < size; i++) {
            objects[i] = data[i];
        }
        data = objects;
    }


    public void checkIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IllegalArgumentException("Add failed ! Required index >=0 and index < size .");
        }
    }

    public void checkIndexForOperate(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Operate failed ! Required index >0 and index <= size .");
        }
    }
}
