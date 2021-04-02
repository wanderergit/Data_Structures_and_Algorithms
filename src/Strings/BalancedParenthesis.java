package Strings;

public class BalancedParenthesis {
    //one method is using stacks
    //we will explore another method

    public static void main(String[] args) {
        String str = "()((())";
        int length = str.length();
        int count = 0;
        for(int i=0; i<length; i++){
            count += getValue(str.charAt(i));
            if(count < 0){
                System.out.println("Not Balanced.");
                break;
            }
        }
        if(count == 0)
            System.out.println("Balanced.");
        else
            System.out.println("Not Balanced.");
    }

    public static int getValue(char ch){
        if(ch == '(')
            return 1;
        return -1;
    }
}
