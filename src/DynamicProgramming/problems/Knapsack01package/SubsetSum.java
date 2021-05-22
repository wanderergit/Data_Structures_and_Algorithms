package DynamicProgramming.problems.Knapsack01package;

import java.util.Scanner;

public class SubsetSum {
    //given an array and a number s, output true if any sum of subset of array = s
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the sum : ");
        int sum = sc.nextInt();

        System.out.println(solver(arr, n, sum));
    }
    public static boolean solver(int[] arr, int n, int sum){
        boolean[][] t = new boolean[n+1][sum+1];
        //initialization
        for(int i=0; i<n+1; i++)
            for(int j=0; j<sum+1; j++){
                if(i==0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                else if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][sum];
    }
}

