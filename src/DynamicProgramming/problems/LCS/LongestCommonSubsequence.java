package DynamicProgramming.problems.LCS;

public class LongestCommonSubsequence {
    /*
        Given two strings, we have to find the length of the longest common subsequence in both the strings
     */

    static class Result{
        int val;
        int[][] table;

        Result(int v, int[][] t){
            val = v;
            table = t;
        }

    }

    public static void main(String[] args) {

        String x = "abcdgh";
        String y = "abedfhr";

        // we will implement it using recursion,  top-down and bottom up

        System.out.println(lcsRecursive(x, y));
        System.out.println(lcsMemoized(x, y));
        System.out.println(lcsBottomUp(x, y).val);

    }

    public static int lcsRecursive(String x, String y){
        int m = x.length();
        int n = y.length();
        return lcsRecursiveHelper(x, y, m, n);
    }

    public static int lcsRecursiveHelper(String x, String y, int m, int n){
        if(m == 0 || n == 0) return 0;
        if(x.charAt(m-1) == y.charAt(n-1)){
            return 1+lcsRecursiveHelper(x, y, m-1, n-1);
        }
        return Math.max(lcsRecursiveHelper(x, y, m-1, n), lcsRecursiveHelper(x, y, m, n-1));
    }

    static int[][] t;
    public static int lcsMemoized(String x, String y){
        int m = x.length();
        int n = y.length();
        t = new int[m+1][n+1];
        for(int i=0; i<m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                t[i][j] = -1;
            }
        }
        return lcsMemoizedHelper(x, y, m, n);
    }

    public static int lcsMemoizedHelper(String x, String y, int m, int n){
        if(m == 0 || n == 0) return 0;
        if(t[m][n] != -1) return t[m][n];
        if(x.charAt(m-1) == y.charAt(n-1)){
            return t[m][n] = 1+lcsRecursiveHelper(x, y, m-1, n-1);
        }
        return t[m][n] = Math.max(lcsRecursiveHelper(x, y, m-1, n), lcsRecursiveHelper(x, y, m, n-1));
    }

    public static Result lcsBottomUp(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] table = new int[m+1][n+1];
        // init is not required as it is zero when n == 0 && m == 0
        // propagation
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    table[i][j] = 1+table[i-1][j-1];
                } else {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }

        return new Result(t[m][n], t);
    }

}
