package Miscellaneous;

import java.util.PriorityQueue;

/*
    https://www.geeksforgeeks.org/minimize-the-sum-calculated-by-repeatedly-removing-any-two-elements-and-inserting-their-sum-to-the-array/
 */
public class MinimizeSumRepeatedRemoval {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 5, 6};
        PriorityQueue<Integer> pq=  new PriorityQueue<>();
        for(int i=0; i< arr.length; i++){
            pq.add(arr[i]);
        }

        int totSum = 0;
        while(pq.size() > 1){
            int one = pq.poll();
            int two = pq.poll();
            // System.out.println(one + " " + two);
            int sum = one + two;
            totSum += sum;
            pq.add(sum);
        }

        System.out.println(totSum);

    }

}
