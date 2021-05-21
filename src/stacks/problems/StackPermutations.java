package stacks.problems;

import java.util.Stack;

public class StackPermutations {
    /*
Check if two arrays are stack permutations of each other
     */

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        int b[] = {2, 1, 3};

        System.out.println(checkStackPermutation(a, b));

    }

    public static boolean checkStackPermutation(int[] a, int[] b){
        int p1 = 0, p2 = 0;
        Stack<Integer> st = new Stack<>();

        while(p1 < a.length && p2<b.length){
            st.push(a[p1]);
            if(st.peek() == b[p2]){
                while(!st.isEmpty() && st.peek() == b[p2]){
                    st.pop();
                    p2++;
                }
            }
            p1++;
        }
        if(p1 == a.length && st.isEmpty()) return true;
        return false;
    }

}
