package DynamicProgramming.problems;

public class NthCatalan {
    /*
    https://www.geeksforgeeks.org/program-nth-catalan-number/
     */

    public static void main(String[] args) {
        System.out.println(nthCatalanRecursive(5));
    }

    public static int nthCatalanRecursive(int n){
        if(n <= 1) return 1;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nthCatalanRecursive(i)*nthCatalanRecursive(n-i-1);
        }
        return sum;
    }

}
