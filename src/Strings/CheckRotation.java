package Strings;

public class CheckRotation {
    public static void main(String[] args) {
        String a = "abcdef";
        String b = "bdcefa";
        checkRotation(a, b);
    }

    public static void checkRotation(String a, String b){
    //neat trick : concat string1 with itself and then check if str2 is the substring of the new string
        String newString = a+a;
        if(isSubstring(newString, b) && a.length()==b.length())
            System.out.println("Yes the two strings are rotations of each other.");
        else
            System.out.println("No the two strings are not rotations of each other.");
    }

    public static boolean isSubstring(String big, String small){
        //use one pointer on big, traverse till we find the character
        int t = 0;
        int len = big.length();
        int i;

        for (i = 0; i < len; i++) {
            if (t == small.length())
                break;
            if (big.charAt(i) == small.charAt(t))
                t++;
            else
                t = 0;
        }

        return t == small.length();
    }

}
