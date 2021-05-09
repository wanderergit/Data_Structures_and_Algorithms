package Greedy;

import java.util.Arrays;

public class FindTheMajorityElement {
    public static void main(String[] args) {
        char[] arr = {'b', 'a', 'c', 'a', 'c', 'b', 'a', 'a', 'c', 'a'};
        /*
            The task is to find the majority element (majority element occupies more than half of the array)
            In one pass
         */
        System.out.println(findMajorityElement(arr));
    }
    public static char findMajorityElement(char[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int l = 0;
        int r = (n-1)/2;
        while(r != n-1){
            if(arr[l] == arr[r]) return arr[l];
            l++;
            r++;
        }
        return '-';
    }
}
