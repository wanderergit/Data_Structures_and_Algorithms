package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaximumAreaOfRectangleInBinaryMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                array[i][j] = Integer.parseInt(br.readLine());
        System.out.println("The maximum area of rectangle in binary matrix is : " + solver(array));
    }
    public static int solver(int[][] array){
        int[] list = new int[array[0].length];
        for(int i=0; i< array.length; i++){
            list[i] = array[0][i];
        }
        int mx = mah(list);
        for(int i=1; i< array.length; i++) {
            for(int j=0; j< array.length; j++) {
                if (array[i][j] == 0)
                    list[j] = 0;
                else
                    list[j] = list[j] + array[i][j];
            }
            mx = Math.max(mx, mah(list));
        }
        return mx;
    }
    public static int mah(int[] array){
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
