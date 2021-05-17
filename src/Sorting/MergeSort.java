package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        // call mergeSort method, which uses divide and conquer approach
        // here we pass two indices, to denote the part of the array currently being looked at
        mergeSort(intArray, 0, intArray.length-1);

        System.out.println(Arrays.toString(intArray));
    }
    public static void mergeSort(int[] intArray, int l, int r){
        /*
            We will only do this if the subarray has atleast 2 elements, i.e, l<r
         */
        if(l < r){
            int mid = (l+r)/2;
            mergeSort(intArray, l, mid);
            mergeSort(intArray, mid+1, r);
            merge(intArray, l, mid, r);
        }
    }

    public static void merge(int[] intArray, int l, int m, int h){
        int i = l;
        int j = m+1;
        int k = l;
        int[] tempArray = new int[intArray.length];
        while(i <= m && j <= h){
            if(intArray[i] < intArray[j]){
                tempArray[k] = intArray[i];
                i++;
            } else {
                tempArray[k] = intArray[j];
                j++;
            }
            k++;
        }
        if(i > m){
            while(j <= h){
                tempArray[k] = intArray[j];
                j++;
                k++;
            }
        } else {
            while(i <= m){
                tempArray[k] = intArray[i];
                i++;
                k++;
            }
        }
        // here we copy the contents back into the original array
        for(int ptr = l; ptr <=h; ptr++){
            intArray[ptr] = tempArray[ptr];
        }
    }
}
