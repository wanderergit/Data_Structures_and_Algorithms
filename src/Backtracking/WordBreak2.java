package Backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {
    public static void main(String[] args) {

    }
    static List<String> wordBreak(int n, List<String> dict, String s) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<dict.size(); i++){
            set.add(dict.get(i));
        }
        List<String> result = new LinkedList<>();
        backtrack(n, set, s, 0, 1, result, "");
        return result;
    }
    public static void backtrack(int n, HashSet<String> set, String s, int start, int end, List<String> result, String temp){
        for(int i=end; i<=s.length(); i++){
            if(set.contains(s.substring(start, i))){
                if(i == s.length()){
                    String a = temp;
                    a = a + s.substring(start, i);
                    result.add(a);
                } else {
                    String a = temp;
                    a = a + s.substring(start, i) + " ";
                    backtrack(n, set, s, i, i+1, result, a);
                }
            }
        }
    }
}
