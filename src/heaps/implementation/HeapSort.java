package heaps.implementation;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 6, 2, 9};
        HeapSort hs = new HeapSort();
        hs.heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        for(int i = n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
    }

    void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        for(int i=n-1; i>=0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
}
