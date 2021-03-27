package stacks.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterToRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements : ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Solver obj = new Solver();
        System.out.println("Output : " + Arrays.toString(obj.solver(arr, n)));
    }

}

class Solver {
    public Integer[] solver(int[] arr, int len){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=len-1; i>=0; i--){
            if(st.isEmpty())
                res.add(-1);
            else {
                if(arr[i] < st.peek())
                    res.add(st.peek());
                else if(arr[i] >= st.peek()){
                    while(st.size() > 0 && arr[i] >= st.peek()){
                        st.pop();
                    }
                    if(!st.isEmpty() && arr[i] < st.peek())
                        res.add(st.peek());
                    else if(st.isEmpty())
                        res.add(-1);
                }
            }
            st.push(arr[i]);
        }
        Integer[] resArray = res.toArray(new Integer[len]);
        return reverse(resArray);
    }
    public Integer[] reverse(Integer[] arr){
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}