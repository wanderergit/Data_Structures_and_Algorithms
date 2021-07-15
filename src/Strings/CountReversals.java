package Strings;

import java.util.Stack;

public class CountReversals {
    int countRev (String s)
    {
        int len = s.length();
        if (len%2 != 0)
            return -1;

        Stack<Character> st=new Stack<>();
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (c =='}' && !st.isEmpty()) {
                if (st.peek()=='{')
                    st.pop();
                else
                    st.push(c);
            }
            else
                st.push(c);
        }

        int red_len = st.size();

        int n = 0;
        while (!st.empty() && st.peek() == '{') {
            st.pop();
            n++;
        }
        return (red_len/2 + n%2);
    }
}
