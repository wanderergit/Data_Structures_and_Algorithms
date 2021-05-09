package Greedy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 7, 8, 12};
        System.out.println(twoSum(arr, 20));
    }

    public static boolean twoSum(int[] arr, int sum){
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while(l<=r){
            if(arr[l] + arr[r] == sum) return true;
            else if(arr[l] + arr[r] < sum) l++;
            else r--;
        }
        return false;
    }

    public boolean hasTwoSum(int[] arr, int sum){
        // gets sorted array
        int l = 0, r = arr.length - 1;
        while(l<=r){
            if(arr[l] + arr[r] == sum) return true;
            else if(arr[l] + arr[r] < sum) l++;
            else r--;
        }
        return false;
    }
}
