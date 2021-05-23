package DynamicProgramming.problems.MCM;
/*
    Refer notes for detailed implementation and format
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        /*
            Given an array which represents the dimensions of matrices, find the min cost to multiply all the matrices
         */
        int[] arr = {40, 20, 30, 10, 40};
        // step 1 : initialise i and j to appropriate values
        int n = arr.length-1;
        int i = 1;
        int j = n-1;

        t = new int[n+1][n+1];
        for(int x=0; x<n+1; x++){
            for(int y =0; y<n+1; y++){
                t[x][y] = -1;
            }
        }

        System.out.println(mcm(arr, i, j));
    }
    public static int[][] t;
    public static int mcm(int[] arr, int i, int j){
        // base condition
        if(i >= j){
            return 0;
        }
        // check if value is already stored
        if(t[i][j] != -1){
            return t[i][j];
        }
        // for loop for various sub-problems
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int minCost = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            if(minCost < min){
                min = minCost;
            }
        }

        return t[i][j] = min;
    }

}
