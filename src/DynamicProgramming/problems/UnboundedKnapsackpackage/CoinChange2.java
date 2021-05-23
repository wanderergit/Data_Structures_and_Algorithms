package DynamicProgramming.problems.UnboundedKnapsackpackage;

public class CoinChange2 {
    /*
        Min. number of coins to reach given sum.
     */
    /*
        There is a similar problem called maximise the cut segments, code is almost same, in notes and in gfg
     */
    public static void main(String[] args) {
        int[] coins = {2, 1, 1};
        int sum = 4;

        System.out.println(minNumberOfCoinsToReachGivenSum(coins, sum));

    }

    public static int minNumberOfCoinsToReachGivenSum(int[] coins, int sum){

        int arrSize = coins.length;
        int[][] t = new int[arrSize+1][sum+1];

        // initialization of first row
        for(int i=0; i<arrSize+1; i++){
            for(int j=0; j<sum+1; j++){
                if(j==0) t[i][j] = 0;
                if(i == 0) t[i][j] = Integer.MAX_VALUE-1;
            }
        }

        // initialisation of second row
        for(int j=1; j<sum+1; j++){
            if(j%coins[0] == 0) t[1][j] = j/coins[0];
            else t[1][j] = Integer.MAX_VALUE-1;
        }

        // propagation
        for(int i=1; i<arrSize+1; i++){
            for(int j=1; j<sum+1; j++){
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(t[i-1][j], t[i][j-coins[i-1]]+1);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[arrSize][sum];
    }



}
