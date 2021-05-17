package Sorting;

import java.util.Arrays;
/*
    Average Case - O(N*logN)
    Worst Case - O(N*N)
 */
public class Quicksort {
    public static void main(String[] args) {

        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        /*
            In quicksort, we take a pivot element and sort the array around the pivot
            Then we partition the array into two halves and then call the partition on both the halves
         */
        int low = 0;
        int high = arr.length-1;

        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        // the low pointer has to be strictly lesser than high
        // this eliminates the cases where we have only one element in the partition (low == high)
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        // we can take random element as pivot
        // or we can even take middle element as pivot, first element as pivot etc.
        int pivot = arr[(int)((low+high)/2)];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i] <= pivot) i++;
            while(arr[j] > pivot) j--;
            if(i < j) swap(arr, i, j);
        }
        swap(arr, (int)((low+high)/2), j);
        return j;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
