package Backtracking;

import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        generate(1, A, B, res, new ArrayList<Integer>());
        return res;
    }

    public void generate(int index, int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp){
        if(k == 0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=index; i<=n; i++){
            temp.add(i);
            generate(i+1, n, k - 1, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}
