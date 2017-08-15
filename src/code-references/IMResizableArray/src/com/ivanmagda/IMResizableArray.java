package com.ivanmagda;

public class IMResizableArray<T> {

    private static int INITIAL_ARRAY_SIZE = 8;

    private T[] array;
    private int size;

    public IMResizableArray(T[] array) {
        if (array == null) {
            defaultInit(INITIAL_ARRAY_SIZE);
        } else {
            this.array = array;
        }
    }

    public IMResizableArray() {
        defaultInit(INITIAL_ARRAY_SIZE);
    }

    public IMResizableArray(int capacity) {
        defaultInit(capacity);
    }

    @SuppressWarnings("unchecked")
    private void defaultInit(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public void set(int index, T item) {
        checkForBounds(index);
        array[index] = item;
    }

    public void append(T value) {
        ensureExtraCapacity();
        array[size] = value;
        size++;
    }

    public T get(int index) {
        checkForBounds(index);
        return array[index];
    }

    private void checkForBounds(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException(index);
    }

    @SuppressWarnings("unchecked")
    private void ensureExtraCapacity() {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}
