package stacks.problems;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Enter a string : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char ele : chars){
            st.push(ele);
        }
        while(!st.isEmpty()){
            res += st.pop();
        }
        System.out.println("Reversed String is : " + res);
    }
}
