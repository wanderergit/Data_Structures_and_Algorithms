package DynamicProgramming.problems.LCS;

public class CountPalindromicSubsequences {
    public static void main(String[] args) {

        String str = "bbca";

        System.out.println(countPS(str));

    }

    public static int countPS(String x){
        int n = x.length();
        String rev = "";
        for(int i=0; i<n; i++){
            rev = x.charAt(i) + rev;
        }

        int[][] t = new int[n+1][n+1];

        // init when i == j, return 1
        for(int i=1; i<n+1; i++){
            t[i][i] = 1;
        }

        // propagation
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(x.charAt(i-1) == rev.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j] + t[i][j-1];
                } else {
                    t[i][j] = t[i-1][j] + t[i][j-1] - t[i-1][j-1];
                }
            }
        }

        return t[n][n];
    }

}
