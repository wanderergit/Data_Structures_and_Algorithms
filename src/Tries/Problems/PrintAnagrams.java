package Tries.Problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class PrintAnagrams {
    public String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> Anagrams(String[] string_list) {

        // the idea is to sort the words into their lexicographically smallest permutation
        // store in hashMap so that we can group anagrams together

        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : string_list){
            String sortedWord = sortWord(word);
            if(!map.containsKey(sortedWord)){
                List<String> li = new LinkedList<>();
                li.add(word);
                map.put(sortedWord, li);
            } else {
                List<String> li = map.get(sortedWord);
                li.add(word);
                map.put(sortedWord, li);
            }
        }


        List<List<String>> result = new LinkedList<>();
        result.addAll(map.values());
        return result;

    }
}
