package DynamicProgramming.problems.LCS;
/*

 */
public class LCSwithDiffOne {
    public static void main(String[] args) {
        int[] A = {10, 9, 4, 5, 4, 8, 6};
        int n = 7;

        System.out.println(longestSubsequence(n, A));
        System.out.println(longestSubsequenceBottomUp(n, A));
    }

    static int longestSubsequence(int n, int A[])
    {
        int i = n-1;
        int compare = -1;
        return solve(A, i, compare);
    }

    static int solve(int[] arr, int i, int compare){
        // if we have reached the last element
        // we check if either that difference of one (element and compare)
        // or if compare = -1, either case we want to include it
        if(i == 0){
            if(Math.abs(arr[i] - compare) == 1 || compare == -1){
                return 1;
            } else {
                return 0;
            }
        }

        // if i > 0
        // we check if either that difference of one (element and compare)
        // or if compare = -1, either case we have the choice of including or excluding it
        // if not, we can only exclude
        if(Math.abs(arr[i] - compare) == 1 || compare == -1){
            return Math.max(1 + solve(arr, i-1, arr[i]), solve(arr, i-1, compare));
        }
        return solve(arr, i-1, compare);

    }

    /*
        GFG code -
        the main idea is to compare every pair of elements and store the best results at every point.
     */
    static int longestSubsequenceBottomUp(int n, int arr[]){
        // Initialize the dp[] array with 1 as a
        // single element will be of 1 length
        int dp[] = new int[n];
        for (int i = 0; i< n; i++)
            dp[i] = 1;

        // Start traversing the given array
        for (int i = 1; i < n; i++)
        {
            // Compare with all the previous
            // elements
            for (int j = 0; j < i; j++)
            {
                // If the element is consecutive
                // then consider this subsequence
                // and update dp[i] if required.
                if ((arr[i] == arr[j] + 1) ||
                        (arr[i] == arr[j] - 1))

                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        // Longest length will be the maximum
        // value of dp array.
        int result = 1;
        for (int i = 0 ; i < n ; i++)
            if (result < dp[i])
                result = dp[i];
        return result;
    }
}
