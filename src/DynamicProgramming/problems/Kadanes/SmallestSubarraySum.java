package DynamicProgramming.problems.Kadanes;

public class SmallestSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 2, -3, 0};
        System.out.println(smallesSubarraySum(arr));
    }
    public static int smallesSubarraySum(int[] arr){
        int mn = arr[0], curr = arr[0];
        for(int i=1; i<arr.length; i++){
            curr = Math.min(curr, curr+arr[i]);
            mn = Math.min(curr, mn);
        }
        return mn;
    }
}
