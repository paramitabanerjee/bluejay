package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class SinglyLinkedList<E> {

    public Node<E> head;

    public void insertData(E data) {

        if(head == null) {
            head = new Node(data);
            head.nextNode = null;
        }
        else {
            Node newNode = new Node(data);
            newNode.nextNode = head;
            head = newNode;
        }

    }

    public E removeData() {
        E data = head.data;

        head = head.nextNode;

        return data;

    }

    public Node findData(E inputdata) {
        Node found = null;

        Node currentNode = head;

        while (currentNode!= null) {
            if(currentNode.data != null && currentNode.data.equals(inputdata)) {
                found = currentNode;
                break;
            }
            currentNode = currentNode.nextNode;
        }
        return found;
    }

    public void deleteData(E inputData) {
        Node nodeToBeDeleted = null;

        Node currentNode = head;
        Node previousNode = null;

        while (currentNode!= null) {
            if(currentNode.data != null && currentNode.data.equals(inputData)) {
                nodeToBeDeleted = currentNode;
                if(previousNode != null) {
                    previousNode.nextNode = nodeToBeDeleted.nextNode;
                } else {
                    head = nodeToBeDeleted.nextNode;
                }
                break;
            }
            else {
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }

        }

    }

    public void displayData() {
        Node currentNode = head;
        while (currentNode!= null) {
            currentNode.displayData();
            currentNode = currentNode.nextNode;
        }
    }

    public void reverseLinkedList() {

        reverse(head);
    }

    public void reverse(Node n) {

        Node current = n;
        Node next = current.nextNode;
        //below is the condition that ends the recursion
        if(next.nextNode==null) {
            head = next; //because this is the last element
            next.nextNode = current; //here we are swapping the order.
            return;
        }
        //recrusively reverse the rest of it
        reverse(next);
        //the interchange the nodes
        next.nextNode = current;
        current.nextNode = null;


    }



}


