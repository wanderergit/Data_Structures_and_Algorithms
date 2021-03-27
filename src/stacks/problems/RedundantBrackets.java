package stacks.problems;

import java.util.Stack;

public class RedundantBrackets {
    public static void main(String[] args) {
        String expression = "((a+b))";
        if(isBracketsRedundant(expression))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static boolean isBracketsRedundant(String s){
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '(' || chars[i] == '+' || chars[i] == '-' ||chars[i] == '*' ||chars[i] == '/'){
                st.push(chars[i]);
            } else if(chars[i] >= 97 && chars[i] <= 122) {
                continue;
            } else if (chars[i] == ')') {
                if(st.peek() == '(')
                    return true;
                else {
                    while(st.peek() != '(')
                        st.pop();
                    st.pop();
                }
            }
        }
        return false;
    }
}
