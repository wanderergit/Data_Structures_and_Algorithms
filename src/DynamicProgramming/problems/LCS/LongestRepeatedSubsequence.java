package DynamicProgramming.problems.LCS;

public class LongestRepeatedSubsequence {

    public static void main(String[] args) {
        String x = "axxxxy";
        System.out.println(longestRepeatingSubsequence(x));


    }

    public static int longestRepeatingSubsequence(String str)
    {
        // we need to compare it with itself,
        // we also need to check if the indices are not same

        int n = str.length();
        int[][] t = new int[n+1][n+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(str.charAt(i-1) == str.charAt(j-1) && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[n][n];

    }

}
