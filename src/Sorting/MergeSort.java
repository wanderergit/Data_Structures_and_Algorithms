package Sorting;

public class MergeSort {
    public static void main(String[] args) {

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        // call mergeSort method, which uses divide and conquer approach
        // here we pass two indices, to denote the part of the array currently being looked at
        mergeSort(intArray, intArray.length, 0, intArray.length-1);
    }
    public static void mergeSort(int[] intArray, int n, int l, int r){
        // base condition

    }
}
