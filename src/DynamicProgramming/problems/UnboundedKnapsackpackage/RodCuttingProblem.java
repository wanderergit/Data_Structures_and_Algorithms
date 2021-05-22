package DynamicProgramming.problems.UnboundedKnapsackpackage;

public class RodCuttingProblem {
    /*
        Given a rod of fixed length L, a lengths <-> price mapping, what is the most optimal way to cut the rod.
        The optimal way maximises the price, return the price

        Ex -> L = 8, length[] = {1, 2, 3, 4, 5, 6, 7, 8}, price[] = {1, 5, 8, 9, 10 , 17, 17, 20}

        Since there is no restriction in cutting the rod into pieces of equal length, this problem is a variation of
        Unbounded Knapsack.
     */

    public static void main(String[] args) {
        int L = 8;
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(maxProfitFromCuttingRod(L, length, price));

    }

    public static int maxProfitFromCuttingRod(int L, int[] length, int[] price){

        int n = length.length;
        int[][] t = new int[n+1][L+1];
        // init is the same as any unbounded knapsack, since all the values where i == 0 && j == 0 are 0 by default,
        // we skip computation

        // propagation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<L+1; j++){
                if(length[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][L];

    }

}
