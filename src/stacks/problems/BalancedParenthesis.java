package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an Expression : ");
        String exp = br.readLine();
        char[] chars = exp.toCharArray();
        Stack<Character> st = new Stack<>();
        int flag = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '('){
                st.push(chars[i]);
            } else if (chars[i] == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }
                else{
                    flag = 1;
                    break;
                }
            } else {
                continue;
            }
        }
        if(flag == 1 || !st.isEmpty()){
            System.out.println("Not Balanced");
        } else {
            System.out.println("Balanced");
        }
    }
}
