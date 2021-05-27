package Backtracking;
/*
https://www.interviewbit.com/problems/subsets-ii/
 */
import java.util.ArrayList;
import java.util.Collections;

public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(A == null) return res;
        generate(0, A, res, new ArrayList<Integer>());
        return res;
    }

    public void generate(int index, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i = index; i<A.size(); i++){
            if(i == index || A.get(i) != A.get(i-1)){
                temp.add(A.get(i));
                generate(i+1, A, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
