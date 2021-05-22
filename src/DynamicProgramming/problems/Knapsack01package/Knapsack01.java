package DynamicProgramming.problems.Knapsack01package;

import java.util.Scanner;

public class Knapsack01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items in the knapsack : ");
        int n = sc.nextInt();
        System.out.println("Enter the capacity of the knapsack : ");
        int capacity = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        System.out.println("Enter the values in the value array : ");
        for(int i=0; i<n; i++)
            val[i] = sc.nextInt();
        System.out.println("Enter the weights in the weight array : ");
        for(int i=0; i<n; i++)
            wt[i] = sc.nextInt();
        // this table is for the bottom-up and top-down approaches
        int[][] t = new int[n+1][capacity+1];
        System.out.println(knapsackRecursive(wt, val, capacity, n));
        System.out.println(knapsackMemoization(wt, val, capacity, n, t));
        System.out.println(knapsackTabulisation(wt, val, capacity, n, t));

    }

    public static int knapsackRecursive(int[] wt, int[] val, int capacity, int n){
        // Base condition : smallest valid input
        if(n==0 || capacity==0)
            return 0;
        // Choices
        if(wt[n-1] <= capacity)
            return Math.max(val[n-1] + knapsackRecursive(wt, val, capacity-wt[n-1], n-1), knapsackRecursive(wt, val, capacity, n-1));
        else if(wt[n-1] > capacity)
            return knapsackRecursive(wt, val, capacity, n-1);
        return -1;
    }

    public static int knapsackMemoization(int[] wt, int[] val, int capacity, int n, int[][] t){
        // Base condition : smallest valid input
        if(n==0 || capacity==0)
            return 0;
        // check if the table already contains a cached solution
        if(t[n][capacity] != 0)
            return t[n][capacity];
        if(wt[n-1] <= capacity)
            return t[n][capacity] = Math.max(val[n-1] + knapsackMemoization(wt, val, capacity-wt[n-1], n-1, t), knapsackMemoization(wt, val, capacity, n-1, t));
        else if(wt[n-1] > capacity)
            return t[n][capacity] = knapsackMemoization(wt, val, capacity, n-1, t);
        return -1;
    }

    public static int knapsackTabulisation(int[] wt, int[] val, int capacity, int n, int[][] t){
        //when n==0 and capacity==0, t[n][capacity] = 0, but this step can be eliminated as all the values are 0 by default
        for(int i=1; i<n+1; i++)
            for(int j=1; j<capacity+1; j++){
                if(wt[i-1] <= j)
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
                else if(wt[i-1] > j)
                    t[i][j] = t[i-1][j];
            }
        return t[n][capacity];
    }
}
