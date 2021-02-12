package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StockSpan {
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
        LinkedList<Integer> l = new LinkedList<>();
        //instead of storing the numbers, we will store the indices of the nearest greater to left

        for(int i=0; i< array.length; i++){
            if(st.isEmpty())
                l.add(-1);
            else if(st.size() > 0 && array[st.peek()] > array[i])
                l.add(st.peek());
            else if(st.size() > 0 && array[st.peek()] <= array[i]){
                while(st.size() > 0 && array[st.peek()] <= array[i])
                    st.pop();
                if(st.isEmpty())
                    l.add(-1);
                else if(array[st.peek()] > array[i])
                    l.add(st.peek());
            }
            st.push(i);
        }

        int[] res = new int[array.length];

        for(int i=0; i<array.length; i++){
            res[i] = i - l.get(i);
        }
        return res;
    }
}
