package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/17/18.
 */
public class UsingSinglyLinkedList {


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

        Node found = singlyLinkedList.findData("Doyel");

        if(found!=null) {
           System.out.println("Found : "+found.data);
        }
        else {
            System.out.println("Not found");
        }

        found = singlyLinkedList.findData("Sona");

        if(found!=null) {
            System.out.println("Found : "+found.data);
        }
        else {
            System.out.println("Not found");
        }

        singlyLinkedList.deleteData("Mitul");

        System.out.println("Data deleted");
    }
}
