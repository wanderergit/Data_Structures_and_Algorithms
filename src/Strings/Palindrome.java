package Strings;

public class Palindrome {
    public static void main(String[] args) {
        String s = "Malayalam";
        checkPalindrome(s);
    }

    public static void checkPalindrome(String str){
        char[] chars = str.toLowerCase().toCharArray();
        int start = 0, end = str.length()-1;
        int flag = 0;
        while(start<=end){
            if(chars[start] != chars[end]){
                System.out.println("Not a palindrome.");
                flag = 1;
                break;
            }
            start++;
            end--;
        }
        if(flag == 0)
            System.out.println("Is a palindrome.");
    }
}
