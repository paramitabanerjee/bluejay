package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class UsingReversalOfSinglyLinkedList {


    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.insertData("Paramita");
        singlyLinkedList.insertData("Dipak");
        singlyLinkedList.insertData("Doyel");
        singlyLinkedList.insertData("Payel");
        singlyLinkedList.insertData("Mitul");
        singlyLinkedList.insertData("Pratim");
        singlyLinkedList.insertData("Mahua");
        singlyLinkedList.insertData("Debu");

        singlyLinkedList.displayData();
        System.out.println("********* Reverse linked list *********");
        singlyLinkedList.reverseLinkedList();

        singlyLinkedList.displayData();


    }

}
