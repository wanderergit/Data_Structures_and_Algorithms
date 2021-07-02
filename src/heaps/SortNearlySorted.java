package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Sort a Nearly sorted or k sorted array -> O(nlogK)
 */
public class SortNearlySorted {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int k){
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        for(; i<n; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                arr[i-k] = minHeap.remove();
            }
        }
        for(int j=i-k; j<n; j++){
            arr[j] = minHeap.remove();
        }
    }
}
