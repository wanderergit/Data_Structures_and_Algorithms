package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solver(s));
    }

    public static String solver(String s){
        Stack<Character> st = new Stack<>();
        String res = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isOperand(c)){
                res += c;
            }
            else {
                if(c == '(')
                    st.push(c);
                else if(c == ')'){
                    while(st.peek() != '('){
                        char newChar = st.pop();
                        res += newChar;
                    }
                    st.pop();
                } else {
                    if (precedence(c) > precedence(st.peek()) || st.isEmpty()) {
                        st.push(c);
                    } else if(precedence(c) <= precedence(st.peek())) {
                        while(precedence(c) <= precedence(st.peek()) || st.peek() == '(') {
                            res += st.pop();
                        }
                        st.push(c);
                    }
                }
            }
        }

        return res;
    }

    public static boolean isOperand(char c) {
        if((c >=65 && c<=90) || (c >= 97 && c<=122))
            return true;
        return false;
    }

    public static int precedence(char c){
        switch (c)
        {
            case '*':
            case '/':
                return 20;
            case '+':
            case '-':
                return 10;
        }
        return -1;
    }
}
