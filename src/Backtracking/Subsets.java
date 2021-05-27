package Backtracking;
/*
    https://www.interviewbit.com/problems/subset/

    we choose each and every element by running a loop through i in the calling function
    then we go though ever next element of i using the j loop in the called function,
    on backtracking to the calling function, we would have exhausted visiting i and therefore
    we wil proceed to i+1 using the loop



 */
import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        if(A==null)
            return null;
        int n = A.size();
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i=0;i<A.size();i++)
            subsets(A, result, new ArrayList(),i);
        return result;
    }
    public static void subsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int i){
        temp.add(A.get(i));
        result.add(temp);
        if(i==A.size())
            return;
        for(int j=i+1;j<A.size();j++){
            subsets(A, result, new ArrayList<Integer>(temp), j);
        }
    }
}
