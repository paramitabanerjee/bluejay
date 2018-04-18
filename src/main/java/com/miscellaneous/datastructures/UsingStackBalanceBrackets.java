package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/16/18.
 */
public class UsingStackBalanceBrackets {

    private static StackImplementation stackImplementation;

    public static void main(String[] args) {
        if(stackImplementation == null) {
            stackImplementation = new StackImplementation(Character.class, 15);
        }

        String myString = "T(es{t [this] o}ut)";
        String myString2 = "T(es{t [(this] o}ut)";

        System.out.println("Bracket balanced = "+myString+" > "+ isBalanced(myString));
        System.out.println("Bracket balanced = "+myString2+" > "+ isBalanced(myString2));
    }


    public static boolean isBalanced(String myString) {

        boolean isBalanced = true;
        for(int i=0; i<myString.length(); i++) {
            char c = myString.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                try {
                    stackImplementation.push(c);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } else if(c==')' || c=='}' || c==']') {
                try {
                    Character popped = (Character)stackImplementation.pop();
                    if(c==')' && popped!='(') {
                        return false;
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return isBalanced;
    }

}
