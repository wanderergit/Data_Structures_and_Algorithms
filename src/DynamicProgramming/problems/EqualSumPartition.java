package DynamicProgramming.problems;

import java.util.Scanner;

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
        if(sum%2 != 0){
            System.out.println(false);
            System.exit(0);
        }
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
