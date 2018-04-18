package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/16/18.
 */
public class UsingQueue {

    private static QueueImplementation queue;

    public static void main(String[] args) {

        queue = new QueueImplementation(Character.class, 55);

        String myStr = "This is a test for queue";

        for(int i=0; i< myStr.length(); i++) {
            char c = myStr.charAt(i);
            try {
                queue.enqueue(c);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        String output = "";
        while(!queue.isEmpty()) {
            try {
                output = output + queue.dequeue();
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Output = "+output);

        /******** when empty in front but rear is full **********/
        queue = new QueueImplementation(Character.class, 5);

        try {
            queue.enqueue('a');
            queue.enqueue('b');
            queue.enqueue('c');
            queue.enqueue('d');
            queue.enqueue('e');
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("queue is full now = "+queue.isFull());

        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("queue size now = "+queue.getSize());
        System.out.println("queue is full now = "+queue.isFull());

        try {
            queue.enqueue('x');
        } catch(Exception e) {
            e.printStackTrace();
        }

        output = "";
        while(!queue.isEmpty()) {
            try {
                output = output + queue.dequeue();
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Output = "+output);

    }
}
