package DynamicProgramming.problems.LIS;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
public class LongestIncresingSubsequence {
    public static void main(String[] args) {
        int arr[] = {0,8,4,12,2,10,6,14,1,9,5, 13,3,11,7,15};
        System.out.println(longestSubsequence(16, arr));
    }
    static int longestSubsequence(int n, int arr[]) {
        int t[] = new int[n];
        Arrays.fill(t, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && t[i] < t[j]+1){
                    t[i] = t[j] + 1;
                }
            }
        }
        int max = -1;
        for(int i=0; i<n; i++){
            if(max < t[i]){
                max = t[i];
            }
        }

        return max;

    }
}
