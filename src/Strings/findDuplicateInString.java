package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class FindDuplicateInString
{
    public static void main(String[] args) {
        String st = "abcssse";
        System.out.println(isPresentDups(st));
        System.out.println(findDups(st));
    }
    public static boolean isPresentDups(String s){
        char[] charArray = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char item : charArray) {
            if(!set.add(item))
                return false;
        }
        return true;
    }
    public static ArrayList<Character> findDups(String s){
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char item : charArray) {
            if(map.get(item) != null)
                map.replace(item, map.get(item)+1);
            else
                map.put(item, 1);
        }
        ArrayList<Character> res = new ArrayList<>();
        for(char item : charArray) {
            if(map.get(item) > 1)
                res.add(item);
        }
        return res;
    }
}