package DynamicProgramming.problems.UnboundedKnapsackpackage;

public class CoinChange1 {
    /*
    Given a value N, find the number of ways to make change for N cents,
    if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.
     */
    public static void main(String[] args) {
        int[] S = {2,5,3,6};
        int m = 4, n = 10;

        System.out.println("The number of ways is : "+count(S, m, n));
    }

    public static long count(int[] S, int m, int n){
        long[][] t = new long[m+1][n+1];

        // init
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i == 0) t[i][j] = 0;
                if(j == 0) t[i][j] = 1;
            }
        }

        // propagation
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(S[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i][j-S[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[m][n];
    }

}
