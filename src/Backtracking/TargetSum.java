package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
/*
    https://www.interviewbit.com/problems/combination-sum/

    The idea behind this problem is to generate all possible combinations, by subtracting the value
    At the current index from target and passing it in the next call

    After backtracking, we have to remove the last added element in the arraylist to explore other options.

 */
public class TargetSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans =new ArrayList<ArrayList<Integer>>();
        if (A==null || A.size()==0) return ans;
        Collections.sort(A);
        generate(0, A, new ArrayList<Integer>(), ans, B);
        return ans;

    }

    public void generate(int index, ArrayList<Integer> a, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans, int target){
        if (target<=0){
            if (target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i=index; i<a.size(); i++){
            // checks if either the same element or element at another index which isn't the same element
            if (i==index || a.get(i)!=a.get(i-1)){
                // adding the element to curr
                curr.add(a.get(i));
                // curr takes the element to explore its options
                generate(i, a, curr, ans, target-a.get(i));
                // this is to remove the last added element after backtracking, (exhausting all options)
                curr.remove(curr.size()-1);}
        }
    }

}
