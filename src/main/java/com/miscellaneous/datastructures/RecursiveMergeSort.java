package com.miscellaneous.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by m840378 on 4/19/18.
 */
public class RecursiveMergeSort<E extends Comparable<E>> {

    private E[] arr;

    public RecursiveMergeSort(E[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {

        //sorted array
        String[] input = {"Anne", "Zil", "Dipak", "Doyel", "Edgar",
                "Mahua", "Naga", "Paramita",  "Payel",
                "Rakesh", "Jasmine", "Varun" };

        RecursiveMergeSort<String> instance = new RecursiveMergeSort<String>(input);

        int lowerBound = 0;
        int upperBound = input.length-1;

        instance.mergeSort(String.class, input, lowerBound, upperBound);

        for(int i=0; i<input.length; i++) {
        System.out.println("Found at index "+input[i]);}

    }

    //returns index of the search key if found
    public void mergeSort(Class<E> c, E[] arr, int lowerBound, int upperBound) {
        if(lowerBound < upperBound) {
            int mid = (lowerBound+upperBound)/2;

            mergeSort(c, arr, lowerBound, mid); //sorts first half
            mergeSort(c, arr, mid+1, upperBound); //sorts rest of it

            //now merge two sorted arrays
            merge(c, arr, lowerBound, mid, upperBound);
        }

    }

    //sort and merge two sections of an array
    //the two sections are marked by boundaries : lowerbound - mid & mid+1 - upperBound

    public void merge(Class<E> c, E[] arr, int lowerBound, int mid, int upperBound) {

        E[] subarr1 = (E[]) Array.newInstance(c, mid-lowerBound+1);
        E[] subarr2 = (E[]) Array.newInstance(c, upperBound-mid);


        for(int i=0; i<subarr1.length; ++i) {
            subarr1[i] = arr[lowerBound+i];
        }


        for(int i=0; i<subarr2.length; ++i) {
            subarr2[i] = arr[mid+1+i];
        }

        //code to sort and merge two arrays
        int k = lowerBound;
        int i=0;
        int j=0;
        while(i<subarr1.length && j< subarr2.length) {
            //here goes the sorting the values in sub arrays and placing them in right index in main array
            if(subarr1[i]!=null && subarr2[j]!=null && subarr1[i].compareTo(subarr2[j]) < 0) {
               arr[k] = subarr1[i];
                i++;
            } else {
                arr[k] = subarr2[j];
                j++;
            }
            k++;
        }
        //most of the cells in arr will be filled by now, but if number of elements in subarr1
        //and subarr2 does nt match the remianing needs to be added to arr
        while(i<subarr1.length) {
            arr[k] = subarr1[i];
            i++;
            k++;
        }

        while(j<subarr2.length) {
            arr[k] = subarr2[j];
            j++;
            k++;
        }


    }


}
