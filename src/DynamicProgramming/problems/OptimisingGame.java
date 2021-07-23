package DynamicProgramming.problems;

/*
    GFG - Player with max score
 */

public class OptimisingGame {
    static Boolean is1winner(int N, int arr[]){
        // we have to calculate the best possible result for p1 using dp
        // then from precomputed total sum, we subtract p1 sum to get p2 sum
        // then we compare p1 sum and p2 sum to find the winner

        int totSum = 0;
        for(int i=0; i<N; i++){
            totSum += arr[i];
        }
        int dp[][][] = new int[2][N][N];
        int firstPlayerScore = rec(arr, 0, N-1, 0, dp);
        int secondPlayerScore  = totSum - firstPlayerScore;
        return firstPlayerScore >= secondPlayerScore;
    }

    static int rec(int[] arr, int start, int end, int isFirst, int[][][] dp){
        if(start>end) return 0;
        if(dp[isFirst][start][end] != 0) return dp[isFirst][start][end];
        if(isFirst == 0){
            dp[isFirst][start][end] = Math.max(rec(arr, start+1, end, 1, dp) + arr[start],
                    rec(arr, start, end-1, 1, dp) + arr[end]);
        } else {
            dp[isFirst][start][end] = Math.min(rec(arr, start+1, end, 0, dp),
                    rec(arr, start, end-1, 0, dp));
        }
        return dp[isFirst][start][end];
    }
}
