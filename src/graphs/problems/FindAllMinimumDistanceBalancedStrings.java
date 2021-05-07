package graphs.problems;

import java.util.*;

/*
    based on Rachit Jain Graph problem -> https://www.youtube.com/watch?v=EE_9U798nvQ
 */
public class FindAllMinimumDistanceBalancedStrings {
    public static void main(String[] args) {
        String s = "(a)())()"; // return all possible solutions -> output : ["(a())()", "(a)()()"]
        ArrayList<String> res = solve(s);
        for(int i=0; i< res.size(); i++){
            System.out.print(res.get(i)+" ");
        }
    }

    public static ArrayList<String> solve(String s){
        ArrayList<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashMap<String, Boolean> vis = new HashMap<>();
        vis.put(s, true);
        q.add(s);
        boolean found = false;
        while(!q.isEmpty()){
            String curr = q.remove();
            ArrayList<String> neighbors = getNeighbors(s);
            if(found) continue;
            for(String neighbor : neighbors){
                if(!vis.containsKey(neighbor) && isBalanced(neighbor)){
                    vis.put(neighbor, true);
                    found = true;
                    res.add(neighbor);
                }
            }
        }
        return res;
    }

    public static boolean isBalanced(String s){
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
        }
        return (count == 0);
    }

    public static ArrayList<String> getNeighbors(String s){
        ArrayList<String> res = new ArrayList<>();
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i) == ')' || s.charAt(i) == '('){
                String newString = s.substring(0, i) + s.substring(i+1);
                res.add(newString);
            }
        }
        return res;
    }
}
