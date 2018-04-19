package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class UsingDoubleEndedLinkedList {


    public static void main(String[] args) {
        DoubleEndedLinkedList<String> doubleEndedLinkedList = new DoubleEndedLinkedList<>();

        doubleEndedLinkedList.insertFirst("Paramita");
        doubleEndedLinkedList.insertFirst("Dipak");
        doubleEndedLinkedList.insertFirst("Doyel");
        doubleEndedLinkedList.insertFirst("Payel");
        doubleEndedLinkedList.insertFirst("Naga");
        doubleEndedLinkedList.insertFirst("Mitul");
        doubleEndedLinkedList.insertFirst("Pratim");
        doubleEndedLinkedList.insertFirst("Mahua");
        doubleEndedLinkedList.insertFirst("Debu");
        doubleEndedLinkedList.displayData();

        Node found = doubleEndedLinkedList.findData("Doyel");

        if(found!=null) {
           System.out.println("Found : "+found.data);
        }
        else {
            System.out.println("Not found");
        }

        found = doubleEndedLinkedList.findData("Sona");

        if(found!=null) {
            System.out.println("Found : "+found.data);
        }
        else {
            System.out.println("Not found");
        }

        doubleEndedLinkedList.deleteData("Naga");

        System.out.println("Data deleted >>>>>>>>>>>>");
        doubleEndedLinkedList.displayData();

        doubleEndedLinkedList.insertLast("Abhijit");
        doubleEndedLinkedList.insertLast("Samrat");
        doubleEndedLinkedList.insertLast("Manik");
        System.out.println("Data added to Tail >>>>>>>>>>>>");

        doubleEndedLinkedList.displayData();
    }
}
