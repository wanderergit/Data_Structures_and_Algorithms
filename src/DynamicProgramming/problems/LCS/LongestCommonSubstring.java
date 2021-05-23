package DynamicProgramming.problems.LCS;

public class LongestCommonSubstring {
    public static void main(String[] args) {

        String x = "ababcdef";
        String y = "qabcdegw";

        System.out.println(longestCommonSubstring(x, y));

    }

    public static int longestCommonSubstring(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] t = new int[m+1][n+1];
        // no need init

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        // finding the max value
        int max = 0;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(max < t[i][j]){
                    max = t[i][j];
                }
            }
        }
        return max;
    }
}
