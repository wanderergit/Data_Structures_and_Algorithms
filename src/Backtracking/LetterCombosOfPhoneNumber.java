package Backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombosOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new LinkedList<>();

        if(digits.length() == 0){
            return res;
        }
        char[] chars = digits.toCharArray();
        recurse(res, "", chars, map, 0);
        return res;
    }

    public void recurse(List<String> res, String temp, char[] chars, HashMap<Character, String> map, int at){
        if(at == chars.length){
            String newString = temp;
            res.add(newString);
            return;
        }
        char curr = chars[at];
        String neighbors = map.get(curr);
        for(int i=0; i<neighbors.length(); i++){
            recurse(res, temp+neighbors.charAt(i), chars, map, at+1);
        }
    }
}
