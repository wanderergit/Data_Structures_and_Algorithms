package DynamicProgramming.problems.LCS;

public class CheckInterleavedStrings {
    /*
    https://practice.geeksforgeeks.org/problems/interleaved-strings/1#
     */
    public static void main(String[] args) {
        String a = "XXY", b = "XXZ", c = "XXYXXZ";
        System.out.println(isInterleave(a, b, c));
    }
    public static boolean isInterleave(String a,String b,String c) {
        // step 1 : get lcs length of (a, c)

        int lcsLengthA = lcs(a, c);
        int lcsLengthB = lcs(b, c);

        // System.out.println(lcsLengthA);
        // System.out.println(lcsLengthB);

        // we need to make sure that whole of string a is there in c
        if(lcsLengthA != a.length()) return false;
        if(lcsLengthB != b.length()) return false;

        // then we make either by separating a from c or by separating b from c,
        // we can get the other string
        // if we separate a from c, we might get b or if we separate b from c,
        // we might get a

        String tempa = getOtherString(b, c);
        String tempb = getOtherString(a, c);

        // System.out.println(tempa);
        // System.out.println(tempb);

        if(tempb.equals(b) || tempa.equals(a)) return true;

        return false;


    }

    public static int lcs(String x, String y){
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

        return table[m][n];
    }

    public static String getOtherString(String x, String y){

        int ptrx = 0;
        int ptry = 0;
        String temp = "";
        while(ptrx<x.length() && ptry < y.length()){

            if(x.charAt(ptrx) == y.charAt(ptry)){
                ptrx++;
                ptry++;
            } else {
                temp += y.charAt(ptry);
                ptry++;
            }
        }
        if(ptrx == x.length()){
            while(ptry != y.length()){
                temp += y.charAt(ptry);
                ptry++;
            }

        }

        return temp;
    }
}
