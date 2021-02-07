package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean res = solver(s);
        if(res)
            System.out.println("Valid Parenthesis!");
        else
            System.out.println("Not a valid parenthesis!");

    }

    public static boolean solver(String s){
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                st.push(c);
            else {
                if(st.isEmpty())
                    return false;
                if(st.peek() == '(')
                    st.pop();
                else
                    return false;
            }
        }
        if(st.isEmpty())
            return true;
        return false;
    }
}
