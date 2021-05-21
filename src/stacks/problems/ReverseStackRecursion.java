package stacks.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseStackRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(1);
        /*
            The first method uses an extra DS, queue to store the elements in the recursion stack.
            Time complexity & Space complexity = O(N)
         */
        Queue<Integer> q = new LinkedList<Integer>();
        System.out.println("Initial Stack -> " + st.toString());
        revStack(st, q);
        System.out.println("After reversal -> " + st.toString());
        /*
            the second method uses constant space, using the insert at bottom method
            Time complexity = O(N*N)
            Space = O(1)
         */
        System.out.println("Initial Stack -> " + st.toString());
        revStack2(st);
        System.out.println("After reversal -> " + st.toString());
    }

    public static void revStack(Stack<Integer> st, Queue<Integer> q){
        if(st.isEmpty()){
            return;
        } else {
            int a = st.pop();
            q.add(a);
            revStack(st, q);
            st.push(q.remove());
        }
    }

    public static void revStack2(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        } else {
            int a = st.pop();
            revStack2(st);
            insertAtBottom(st, a);
        }
    }

    public static void insertAtBottom(Stack<Integer> st, int x){
        if(st.isEmpty()){
            st.push(x);
        } else {
            int a = st.pop();
            insertAtBottom(st, x);
            st.push(a);
        }
    }

}
