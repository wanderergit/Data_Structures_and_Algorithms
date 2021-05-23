package DynamicProgramming.problems.LCS;

public class PrintLCS {
    public static void main(String[] args) {

        String x = "aggtab";
        String y = "gxtxayb";


        // get table after completeing lcs computation

        int[][] t = LongestCommonSubsequence.lcsBottomUp(x, y).table;
        int i = t.length;
        int j = t[0].length;
        String res = "";
        while(i > 0 && j > 0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                res = x.charAt(i-1) + res;
            } else {
                if(t[i-1][j] > t[i][j-1]){
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println(res);

    }
}
