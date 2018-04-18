package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class UsingDoublyLinkedList {


    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.insertFirst("Paramita");
        doublyLinkedList.insertFirst("Dipak");
        doublyLinkedList.insertFirst("Doyel");
        doublyLinkedList.insertFirst("Payel");
        doublyLinkedList.insertFirst("Naga");
        doublyLinkedList.insertFirst("Mitul");
        doublyLinkedList.insertFirst("Pratim");
        doublyLinkedList.insertFirst("Mahua");
        doublyLinkedList.insertFirst("Debu");
        doublyLinkedList.displayData();

        Node found = doublyLinkedList.findData("Doyel");

        if(found!=null) {
           System.out.println("Found : "+found.data);
        }
        else {
            System.out.println("Not found");
        }

        found = doublyLinkedList.findData("Sona");

        if(found!=null) {
            System.out.println("Found : "+found.data);
        }
        else {
            System.out.println("Not found");
        }

        doublyLinkedList.deleteData("Naga");

        System.out.println("Data deleted >>>>>>>>>>>>");
        doublyLinkedList.displayData();

        doublyLinkedList.insertLast("Abhijit");
        doublyLinkedList.insertLast("Samrat");
        doublyLinkedList.insertLast("Manik");
        System.out.println("Data added to Tail >>>>>>>>>>>>");

        doublyLinkedList.displayData();
    }
}
