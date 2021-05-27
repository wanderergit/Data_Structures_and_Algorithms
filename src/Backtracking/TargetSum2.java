package Backtracking;
/*
    This is a variation of the first one where we can only choose each element once.
    the idea behind both are the same.
 */
import java.util.ArrayList;
import java.util.Collections;

public class TargetSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(a == null || a.size() == 0) return res;
        Collections.sort(a);
        generate(0, a, new ArrayList<Integer>(), res, b);
        return res;
    }

    public void generate(int index, ArrayList<Integer> a, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res, int target){
        if(target <= 0){
            if(target == 0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i=index; i<a.size(); i++){
            if(i == index || a.get(i) != a.get(i-1)){
                // adding the element to curr
                curr.add(a.get(i));
                // curr takes the element to explore its options
                generate(i+1, a, curr, res, target-a.get(i));
                // this is to remove the last added element after backtracking, (exhausting all options)
                curr.remove(curr.size()-1);

            }
        }
    }
}
