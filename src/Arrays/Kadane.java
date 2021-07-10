package Arrays;

public class Kadane {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};
        System.out.println("Max sum in a contiguous sub array is : " + maxSumSubarray(arr, arr.length));
    }
    public static int maxSumSubarray(int[] arr, int n){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        for(int i=0; i<n; i++){
            currSum += arr[i];
            if(maxSum < currSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
                len = 0;
            } else {
                len++;
                if(maxLen < len)
                    maxLen = len;
            }
        }
        return maxLen;
    }
}
