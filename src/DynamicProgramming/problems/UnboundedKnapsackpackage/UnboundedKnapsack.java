package DynamicProgramming.problems.UnboundedKnapsackpackage;

/*
    Given a list of weights and values wt[] & val[], find which elements can be added into a knapsack of capacity W.
    Since this is unbounded knapsack, we can assume that unlimited capacity of the same element is available to add.
 */

public class UnboundedKnapsack {
    public static void main(String[] args) {

        int wt[] = {1, 2, 3, 4, 5, 6};
        int val[] = {34, 45, 12, 67, 44, 72};

        int W = 10;

        System.out.println(unboundedKnapsack(wt, val, W));

    }

    public static int unboundedKnapsack(int[] wt, int[] val, int capacity){
        int n = wt.length;
        int[][] t = new int[n+1][capacity+1];

        // init (same as we do in bounded knapsack)
        // we initialise all the i==0, and j==0 cells to zero
        // since default values are zero, we skip this computation

        // propagation
        for(int i=1; i<n+1; i++)
            for(int j=1; j<capacity+1; j++){
                if(wt[i-1] <= j)
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]], t[i-1][j]);
                else if(wt[i-1] > j)
                    t[i][j] = t[i-1][j];
            }
        return t[n][capacity];
    }

}
