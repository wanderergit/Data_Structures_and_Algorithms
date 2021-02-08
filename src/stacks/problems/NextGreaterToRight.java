package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterToRight {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++)
            array[i] = Integer.parseInt(br.readLine());
        System.out.println(Arrays.toString(solver(array)));
    }
    public static int[] solver(int[] array){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[array.length];

        res[array.length-1] = -1;
        st.push(-1);
        st.push(array[array.length-1]);
        for(int i=array.length - 2; i>=0; i--){
            if(array[i] < st.peek()){
                res[i] = st.peek();
                st.push(array[i]);
            } else {
                while(!(array[i] < st.peek()) && st.peek() != -1){
                    st.pop();
                }
                res[i] = st.peek();
                st.push(array[i]);
            }
        }
        return res;
    }
}
