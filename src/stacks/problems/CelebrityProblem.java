package stacks.problems;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {{0,0,1,0}, {0,0,1,0},{0,0,0,0},{0,0,1,0}};
        int length = matrix.length;
        celebFinder(matrix, length);
    }

    public static void celebFinder(int[][] matrix, int len){
        Stack<Integer> st = new Stack<>();
        //pushing the celeb indexes into the stack
        for(int i=0; i<len; i++){
            st.push(i);
        }
        //taking two indexes at a time and comparing
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            if(matrix[a][b] == 1)
                st.push(b);
            else
                st.push(a);
        }
        //when one element is left, check if that element is celeb
        int ele = st.pop();
        int flag = 0;
        for(int i=0; i<len; i++){
            if(matrix[ele][i] == 1){
                flag++;
                break;
            }
            if(matrix[i][ele] == 0 && i!=ele){
                flag++;
                break;
            }
        }
        if(flag == 0)
            System.out.println(ele + " is the celebrity.");
        else
            System.out.println("No one is a celebrity.");
    }
}
