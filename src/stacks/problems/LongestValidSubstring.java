package stacks.problems;

import java.util.Stack;

public class LongestValidSubstring {
    public static void main(String[] args) {
        String expression = "())(())";
        System.out.println(findLongest(expression, expression.length()));;
    }
    public static int findLongest(String str, int length){
        char[] chars = str.toCharArray();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result = 0;
        for(int i=0; i<length; i++){
            if(chars[i] == '('){
                st.push(i);
            } else {
                if(!st.isEmpty())
                    st.pop();
                if(!st.isEmpty())
                    result = Math.max(result, i-st.peek());
                else
                    st.push(i);
            }
        }
        return result;
    }
}
