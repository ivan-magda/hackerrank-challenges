package com.ivanmagda.core.stack;

import com.ivanmagda.core.linkedlist.IMLinkedList;

/**
 * LIFO
 *
 * @param <T> value type
 */
public class IMStack<T> {

    private IMLinkedList<T> linkedList;

    public IMStack() {
        this.linkedList = new IMLinkedList<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public void push(T value) {
        linkedList.addFirst(value);
    }

    public T pop() {
        return linkedList.removeFirst();
    }
}
