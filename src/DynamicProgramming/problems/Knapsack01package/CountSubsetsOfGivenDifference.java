package DynamicProgramming.problems.Knapsack01package;

public class CountSubsetsOfGivenDifference {
    /*
        Given an array of integers, we have to find how many times, when the array is split into parts and their sums
        S1 and S2 are calculated, s1 - s2 will be equal to the given Difference X.

        This problem is very similar to the count of subset sum problem.

        Approach : S1-S2 = diff, S1+S2 = Range
        => S1 = (diff + Range)/2
        The problem is now reduced to counting the number of times the sum (diff + range) / 2 can be achieved by any subset in array
     */
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        System.out.println(solver(arr, diff));
    }

    public static int solver(int[] arr, int diff){
        // find the sum of all the elements in the array (range)
        int range = 0;
        for(int item : arr){
            range += item;
        }

        // find the sum to pass in subSumCount function
        if((diff + range)%2 != 0) return -1;

        int sum = (diff + range) / 2;
        return subsetSumCount(arr, sum);
    }

    public static int subsetSumCount(int[] arr, int sum){
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];

        // initialisation
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i == 0) t[i][j] = 0;
                if(j == 0) t[i][j] = 1;
            }
        }

        // propagation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }

}
