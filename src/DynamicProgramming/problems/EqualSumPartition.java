package DynamicProgramming.problems;

import java.util.Scanner;
/*
    In the equal sum partition problem, first off all we have to check if the total sum of the array is even
    if the total sum of the array is odd, then it cannot be divided into two equal parts and hence it is not possible to
    find equal sum partition.
    if the sum is even then we have to find if there exists a subset which sums to exactly half of the total sum, then return true
    else return false
 */
public class EqualSumPartition {
    //return true if the array can be divided into two parts with equal sum
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        System.out.println("Enter the elements of the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        // if the total sum is odd, return false
        if(sum%2 != 0){
            System.out.println(false);
            System.exit(0);
        }
        // if the total sum is even, proceed to check if subset exists
        System.out.println(solver(arr, n, sum/2));
    }

    public static boolean solver(int[] arr, int n, int sum){
        boolean[][] t = new boolean[n+1][sum+1];
        //init
        for(int i=0; i<n+1; i++)
            for(int j=0; j<sum+1; j++){
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        //choice diagram
        for(int i=1; i<n+1; i++)
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                else if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
            }
        return t[n][sum];
    }
}
