package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class SinglyLinkedList<E> {

    private Node<E> head;

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
        Node previousNode = null;

        while (currentNode!= null) {
            currentNode.displayData();
            currentNode = currentNode.nextNode;
        }
    }

}


