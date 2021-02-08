package stacks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array : ");
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                array[i][j] = Integer.parseInt(br.readLine());
        System.out.println(solver(array) + " is the celeb.");
    }
    public static int solver(int[][] array) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<array[0].length; i++)
            st.push(i);
        while(st.size()!=1){
            int a = st.pop();
            int b = st.pop();
            if(array[a][b] == 1 && array[b][a] == 0)
                st.push(b);
            else
                st.push(a);
        }
        int res = st.pop();
        for(int i=0; i<array[0].length; i++){
            if(array[res][i] != 0)
                return -1;
            if(array[i][res] == 0 && i != res)
                return -1;
        }
        return res;
    }
}
