package com.miscellaneous.datastructures;

import java.lang.reflect.Array;

/**
 * Created by m840378 on 4/16/18.
 */
public class QueueImplementation<E> {

    //first in first out
    //queue has a front and an rear

    private E[] arr;

    private int front = 0;
    private int rear = -1;

    private int capacity = 0;
    private int size = 0;

    public QueueImplementation(Class<E> c, int mmaxSize) {
        capacity = mmaxSize;
        arr = (E[]) Array.newInstance(c, mmaxSize);
    }

    public void enqueue(E c) throws Exception { //add to the rear of the queue
        if(isFull()) {
            throw new Exception("Queue is full");
        }
        rear = rear + 1;
        //if rear has reached max size but queue is not full we need to make adjustments to accomodate the new elements
        if(rear == capacity-1){
            rear = 0;
        }

        arr[rear] = c;
        size = size+1;
    }

    public E dequeue() throws Exception { //remove from the front of the queue
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        E temp = arr[front];
        front = front+1;
        size = size-1;

        if(front == capacity-1){
            front = 0;
        }
        return temp;
    }

    public E peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return (getSize() == 0 ? true : false);
    }

    public boolean isFull() {
        return (capacity == size? true : false);
    }

    public int getSize() {
        return size;
    }
}
