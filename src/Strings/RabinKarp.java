package Strings;
//    create a function to get the hashCode of pattern
//    create a function the next hashCode value of string traversal
public class RabinKarp {

    public static void main(String[] args) {
        String str = "accccaaadefkasccs";
        String pattern = "fs";
        if(rabinKarp(str, pattern))
            System.out.println("Pattern found in string");
        else
            System.out.println("Pattern not found in string");
    }

    public static boolean rabinKarp(String str, String pattern){
        long pattCode = getHashCode(pattern);
        int pattLen = pattern.length();
        int flg = 0;
        int start = 0, end = pattLen;
        while(end <= str.length()) {
            String subStr = str.substring(start, end);
            long strCode = getHashCode(subStr);
            if(strCode == pattCode){
                int t = 0;
                for(int i=0; i<pattLen; i++){
                    if(subStr.charAt(i) != pattern.charAt(i))
                        break;
                    else
                        t++;
                }
                if(t==pattLen){
                    flg = 1;
                    break;
                }
            }
            start++;
            end++;
        }
        return (flg == 1);
    }

    public static long getHashCode(String pattern){
        int length = pattern.length();
        long res = 0;
        for(int i=0; i<length; i++){
            res += (long)(pattern.charAt(i)-'a'+1) * Math.pow(26.0, length-i-1);
        }
        return res;
    }
}
