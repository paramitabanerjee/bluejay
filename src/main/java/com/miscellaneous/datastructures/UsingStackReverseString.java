package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/16/18.
 */
public class UsingStackReverseString {

    private static StackImplementation stackImplementation;

    public static void main(String[] args) {
        if(stackImplementation == null) {
            stackImplementation = new StackImplementation(Character.class, 15);
        }

        String myString = "Test this out";

        for(int i=0; i<myString.length(); i++) {
            char c = myString.charAt(i);
            try {
                stackImplementation.push(c);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Stack size = "+ stackImplementation.getSize());

        String reverseString = "";
        while(!stackImplementation.isEmpty()) {
            try{
                reverseString = reverseString+stackImplementation.pop();
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(reverseString);

    }
}
