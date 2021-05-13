package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        /*
            The selection sort algorithm selects the minimum element from the unsorted portion at every iteration
            Then it swaps it with the first element of the unsorted portion.
         */

        System.out.println(Arrays.toString(selectionSort(intArray, intArray.length)));

    }

    public static int[] selectionSort(int[] intArray, int n){

        // min stores the index of the min element
        int minIndex = 0;
        int min;
        for(int i=0; i<n; i++){
            min = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                if(intArray[j] < min) {
                    minIndex = j;
                    min = intArray[j];
                }
            }
            swap(i, minIndex, intArray);
        }

        return intArray;

    }

    public static void swap(int i, int j, int[] intArray){
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }

}
