package Arrays.SlidingWindow;
/*
    Sliding window technique - Variable length, Leetcode
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(arr, k));
    }
    public static int longestOnes(int[] arr, int k) {
        // at any time, we need to have only k 0's in window.
        // this is variable length sliding window technique

        int l = 0, r = 0;
        int currMax = 0;
        int max = 0;
        int currZeros = 0;

        while(r < arr.length){

            if(arr[r] == 1){
                currMax++;
                if(currMax >= max){
                    max = currMax;
                }
            } else {
                if(currZeros < k){
                    currZeros++;
                    currMax++;
                    if(currMax >= max){
                        max = currMax;
                    }
                } else {
                    while(arr[l]!=0 && l!=r){
                        currMax--;
                        l++;
                    }
                    l++;
                }
            }
            r++;
        }
        return max;
    }
}
