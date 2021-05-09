package Greedy;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 7, 8, 12};
        Arrays.sort(arr);
        System.out.println(threeSum(arr, 3));
    }
    public static boolean threeSum(int[] arr, int sum){
        TwoSum obj = new TwoSum();
        for(int i : arr){
            if(obj.hasTwoSum(arr, sum - i)) return true;
        }
        return false;
    }
}
