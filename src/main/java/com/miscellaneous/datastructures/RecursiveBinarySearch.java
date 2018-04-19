package com.miscellaneous.datastructures;

/**
 * Created by m840378 on 4/19/18.
 */
public class RecursiveBinarySearch<E extends Comparable<E>> {

    private E[] arr;

    public RecursiveBinarySearch(E[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {

        //sorted array
        String[] input = {"Anne", "Dipak", "Doyel", "Edgar",
                "Mahua", "Naga", "Paramita",  "Payel",
                "Rakesh", "Sam", "Varun" };

        RecursiveBinarySearch<String> recursiveBinarySearch = new RecursiveBinarySearch<String>(input);

        int lowerBound = 0;
        int upperBound = input.length-1;
        int index = recursiveBinarySearch.binarySearch("Sam", upperBound, lowerBound);

        System.out.println("Found at index "+index);

        index = recursiveBinarySearch.binarySearch("Lakshmi", upperBound, lowerBound);

        System.out.println("Found at index "+index);

    }

    //returns index of the search key if found
    public int binarySearch(E searchKey, int upperBound, int lowerBound) {

        int index = -1;
        int currentIndex = (lowerBound + upperBound)/2;

        if(lowerBound > upperBound) {
            return -1;
        }

        if(arr[currentIndex] != null && arr[currentIndex].equals(searchKey)) {
            return currentIndex;
        }
        else if(arr[currentIndex] != null && arr[currentIndex].compareTo(searchKey) < 0) {
             //search key must be in upper bound
            lowerBound = currentIndex+1;
            //upperBound remains same

        }
        else if(arr[currentIndex] != null && arr[currentIndex].compareTo(searchKey) > 0) {
            //search key must be in lower bound
            upperBound = currentIndex-1;
        }
        index = binarySearch(searchKey, upperBound, lowerBound);

        return index;

    }
}
