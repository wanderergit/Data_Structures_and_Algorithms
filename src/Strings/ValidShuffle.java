package Strings;

import java.util.HashMap;

public class ValidShuffle {
    public static void main(String[] args) {
        String st = "abcde";
        String st2 = "ctade";
        System.out.println(isValidShuffle(st, st2));
    }
    public static boolean isValidShuffle(String s, String t){
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char item : arr1) {
            if(map.get(item) != null)
                map.put(item, map.get(item) + 1);
            else
                map.put(item, 1);
        }
        for(char item : arr2){
            if(map.get(item) == null)
                return false;
            else if(map.get(item) > 1)
                return false;
        }
        return true;
    }
}
