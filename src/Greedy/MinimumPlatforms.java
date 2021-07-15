package Greedy;

import java.util.Arrays;

 //https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // we need to find max simultaneously parked trains at any point of time
        Arrays.sort(arr);
        Arrays.sort(dep);
        // use two pointers on arrival and departure

        int ptr1 = 0, ptr2 = 0;
        int count = 0;
        int maxCount = 0;
        while(ptr1 < n && ptr2 < n){
            if(arr[ptr1] <= dep[ptr2]){
                count++;
                ptr1++;
            } else if(arr[ptr1] > dep[ptr2]){
                count--;
                ptr2++;
            }
            if(maxCount < count){
                maxCount = count;
            }
        }

        return maxCount;
    }
}
