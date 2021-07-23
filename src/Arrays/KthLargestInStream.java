package Arrays;

import java.util.PriorityQueue;

public class KthLargestInStream {
    static int[] kthLargest(int k, int[] arr, int n) {
        int res[] = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            if(pq.size() == k){
                if(arr[i] <= pq.peek()){
                    res[i] = pq.peek();
                } else {
                    pq.poll();
                    pq.add(arr[i]);
                    res[i] = pq.peek();
                }
            } else if (pq.size() < k){
                pq.add(arr[i]);
                if(pq.size() == k){
                    res[i] = pq.peek();
                } else {
                    res[i] = -1;
                }
            }
        }
        return res;
    }
}
