package stacks.problems;

import java.util.Stack;

public class InsertAtBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(1);

        insertAtBotttom(st, 5);
        System.out.println(st.toString());
    }
    public static void insertAtBotttom(Stack<Integer> st, int x){
        if(st.isEmpty()){
            st.push(x);
        } else {
            int a = st.pop();
            insertAtBotttom(st, x);
            st.push(a);
        }
    }
}
