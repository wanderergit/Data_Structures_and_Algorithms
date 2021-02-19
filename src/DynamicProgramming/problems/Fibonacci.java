package DynamicProgramming.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static int[] memoArray = new int[51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number n : ");
        int number = Integer.parseInt(br.readLine());

//        System.out.println("From recursive : " + fibRecursive(number));
        System.out.println("From memoized : " + fibMemoization(number));
    }
    public static int fibRecursive(int n){
        if(n<=2) return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }
    public static int fibMemoization(int n){
        if(memoArray[n] != 0) {
            System.out.println(memoArray[n]);
            return memoArray[n];
        }
        if(n<=2) return 1;
        return memoArray[n] = fibRecursive(n-1) + fibRecursive(n-2);
    }
}
