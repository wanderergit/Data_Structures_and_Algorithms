package DynamicProgramming.problems;

public class CountSubsetsOfGivenSum {
    //count the number of subsets in the array that add up to the given sum
    public static void main(String[] args) {


        int[] arr = {2, 3, 5, 6, 8, 10};
        int n = 6;
        int sum = 10;

        System.out.println(solver(arr, n, sum));
    }
    public static int solver(int[] arr, int n, int sum){
        int[][] t = new int[n+1][sum+1];
        //base condition -> the first column should be all 1s cause empty subset can give sum = 0
        for(int i=0; i<n+1; i++)
            t[i][0] = 1;
        //choice diagram
        for(int i=1; i<n+1; i++)
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                else if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
            }
        return t[n][sum];
    }
}
