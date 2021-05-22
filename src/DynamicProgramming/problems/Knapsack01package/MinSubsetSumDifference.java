package DynamicProgramming.problems.Knapsack01package;

import java.util.LinkedList;
import java.util.Scanner;

public class MinSubsetSumDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int range = 0;
        for(int i=0; i<n; i++)
            range += arr[i];

        System.out.println(solver(arr, n, range));
    }
    public static int solver(int[] arr, int n, int sum){
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
        //prev portion was all subset sum
        //add a bit of code for min subset sum difference

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<sum+1; i++){
            // filtering out the valid candidates for sum of subset
            // these will be the true values in the last row
            if(t[n-1][i])
                list.add(sum);
        }

        int min = Integer.MAX_VALUE;
        for(int element : list){
            min = Math.min(min, sum-(2*element));
        }

        return min;
    }
}
