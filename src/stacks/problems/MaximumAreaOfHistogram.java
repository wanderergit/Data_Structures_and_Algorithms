package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumAreaOfHistogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++)
            array[i] = Integer.parseInt(br.readLine());
        System.out.println("The maximum area of the histogram is : " + solver(array));
    }
    public static int solver(int[] array){
        Stack<Integer> st = new Stack<>();
        List<Integer> nsl = new ArrayList<>();
        List<Integer> nsr = new ArrayList<>();

        //finding nearest greater to left
        for(int i=0; i< array.length; i++){
            if(st.isEmpty())
                nsl.add(-1);
            else if(array[st.peek()] < array[i])
                nsl.add(st.peek());
            else if(array[st.peek()] >= array[i]){
                while(st.size() > 0 && array[st.peek()] >= array[i])
                    st.pop();
                if(st.isEmpty())
                    nsl.add(-1);
                else if(array[st.peek()] < array[i])
                    nsl.add(st.peek());
            }
            st.push(i);
        }
        st.clear();

        //finding nearest greater to right
        for(int i=array.length-1; i>=0 ; i--){
            if(st.isEmpty())
                nsr.add(array.length);
            else if(array[st.peek()] < array[i])
                nsr.add(st.peek());
            else if(array[st.peek()] >= array[i]){
                while(st.size() > 0 && array[st.peek()] >= array[i])
                    st.pop();
                if(st.isEmpty())
                    nsr.add(array.length);
                else if(array[st.peek()] < array[i])
                    nsr.add(st.peek());
            }
            st.push(i);
        }

        Collections.reverse(nsr);


        int[] width = new int[array.length];
        for(int i=0; i< array.length; i++){
            width[i] = nsr.get(i) - nsl.get(i) - 1;
        }
        int[] area = new int[array.length];
        for(int i=0; i< array.length; i++){
            area[i] = array[i]*width[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            max = Math.max(max, area[i]);
        }
        return max;
    }
}
