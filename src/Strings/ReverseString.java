package Strings;

public class ReverseString {
    public static void main(String[] args) {
        String s = "This is a sample string";
        reverse1(s);
        reverse2(s);
        reverse3(s);
    }

    public static void reverse1(String str){
        char[] chars = str.toCharArray();
        int start = 0, end = str.length()-1;
        while(start <= end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        System.out.println("Method 1 : " + String.valueOf(chars));
    }

    public static void reverse2(String str){
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println("Method 2 : " + sb);
    }

    public static void reverse3(String str){
        String res = "";
        for(int i=0; i<str.length(); i++){
            res = str.charAt(i) + res;
        }
        System.out.println("Method 3 : " + res);
    }
}
