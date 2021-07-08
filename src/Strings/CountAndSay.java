package Strings;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if(n == 1) return "1";
        String prev = countAndSay(n-1);
        int count = 1;
        String newString = "";
        for(int i=0; i<prev.length()-1; i++){
            if(prev.charAt(i) == prev.charAt(i+1))
                count += 1;
            else {
                newString = newString+count+prev.charAt(i);
                count = 1;
            }
        }
        newString = newString+count+prev.charAt(prev.length()-1);
        return newString;
    }
}
