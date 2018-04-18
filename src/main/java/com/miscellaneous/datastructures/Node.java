package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class Node<E> {
    public E data;
    public Node nextNode;

    public Node(E data) {
        this.data = data;
    }

    public void displayData() {
        System.out.println(this.data);
    }
}
