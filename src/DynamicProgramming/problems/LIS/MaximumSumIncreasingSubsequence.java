package DynamicProgramming.problems.LIS;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {0,8,4,12,2,10,6,14,1,9,5, 13,3,11,7,15};
        System.out.println(longestSubsequence(16, arr));
    }
    static int longestSubsequence(int n, int arr[])
    {
        int t[] = new int[n];
        for(int i=0; i<n; i++)
            t[i] = arr[i];

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] && t[i] < t[j]+arr[i]){
                    t[i] = t[j] + arr[i];
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
