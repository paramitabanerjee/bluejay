package com.miscellaneous.datastructures;

import java.lang.reflect.Array;

/**
 * Created by m840378 on 4/16/18.
 */
public class StackImplementation<E> {

    private E[] arr;
    int top = -1;
    int size = 0;
    int maxSize = 0;

    public StackImplementation(Class<E> c, int mmaxSize) {
        maxSize = mmaxSize;
        arr = (E[]) Array.newInstance(c, mmaxSize);
    }

    public void push(E c) throws Exception {
        if(isFull()) {
            throw new Exception("Stack is full");
        }
        top = top+1;
        size = size+1;
        arr[top] = c;
    }

    public E pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        E temp = arr[top];
        top = top-1;
        size = size-1;
        return temp;

    }

    public E peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return (getSize() == 0 ? true : false);
    }

    public boolean isFull() {
        return (maxSize == size? true : false);
    }

    public int getSize() {
        return size;
    }
}
