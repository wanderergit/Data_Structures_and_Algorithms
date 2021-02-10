package DynamicProgramming.problems;

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
        System.out.println("Enter the values in the weight array : ");
        for(int i=0; i<n; i++)
            wt[i] = sc.nextInt();

        System.out.println(knapsackRecursive(wt, val, capacity, n));

    }

    public static int knapsackRecursive(int[] wt, int[] val, int capacity, int n){
        if(n==0 || capacity==0)
            return 0;
        if(wt[n-1] <= capacity)
            return Math.max(val[n-1] + knapsackRecursive(wt, val, capacity-wt[n-1], n-1), knapsackRecursive(wt, val, capacity, n-1));
        else if(wt[n-1] > capacity)
            return knapsackRecursive(wt, val, capacity, n-1);
        return -1;
    }
}
