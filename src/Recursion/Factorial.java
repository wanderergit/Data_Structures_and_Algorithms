package Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(iterativeFactorial(5));
    }
    public static int iterativeFactorial(int n){
        if(n == 0)
            return 1;
        int factorial = 1;
        for(int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }
}
