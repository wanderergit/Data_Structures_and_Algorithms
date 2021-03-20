package Searching.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestElementInRotatedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        System.out.println(binSearch(arr));
    }
    public static int binSearch(int[] arr) {
        int n = arr.length;
        int start = 0, end = n-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(mid == 0){
                if(arr[mid+1] > arr[mid])
                    return arr[mid];
                else
                    return arr[mid +1];
            } else if(mid == n-1){
                if(arr[mid-1] > arr[mid])
                    return arr[mid-1];
                else
                    return arr[mid];
            }
            if(arr[mid-1] > arr[mid+1]){
                if(arr[mid]>arr[mid+1])
                    return arr[mid+1];
                else
                    return arr[mid];
            } else if(arr[mid] > arr[0]){
                start = mid +1;
            } else if(arr[mid] < arr[0]){
                end = mid - 1;
            }
        }
        return -1;
    }
}
