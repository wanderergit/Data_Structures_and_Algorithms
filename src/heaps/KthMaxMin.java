package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthMaxMin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array : ");
        int []array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k : ");
        int k = sc.nextInt();
        solver(array, n, k);
    }

    public static void solver(int[] arr, int length, int k){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<length; i++){
            minHeap.add(arr[i]);
            maxHeap.add(arr[i]);
        }
        while(k-- > 1){
            minHeap.remove();
            maxHeap.remove();
        }

        System.out.println("The kth maximum number is : " + maxHeap.peek());
        System.out.println("The kth minimum number is : " + minHeap.peek());

    }

}
