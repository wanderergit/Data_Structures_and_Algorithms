package graphs.problems;

import java.util.*;

public class WordDictionary {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create a graph where nodes are words and edges connect two nodes which differ by one character
        // do a bfs to find the shortest path in unweighted graph from src to dest

        // the graph should be created using a HashMap<String, List>
        // the key is the Pattern that the word represents, the value is a list of all the words in wordList
        // that falls in that pattern

        if(!wordList.contains(endWord))
            return 0;

        HashMap<String, List<String>> nei = new HashMap<>();
        wordList.add(beginWord);

        // construct the graph
        for(String word : wordList){
            for(int i=0; i<word.length(); i++){
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                if(nei.containsKey(pattern)){
                    nei.get(pattern).add(word);
                } else {
                    List<String> li = new LinkedList<>();
                    li.add(word);
                    nei.put(pattern, li);
                }
            }
        }

        HashSet<String> vis = new HashSet();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                String word = q.remove();
                if(word.equals(endWord))
                    return res;
                for(int j=0; j<word.length(); j++){
                    String pattern = word.substring(0, j) + "*" + word.substring(j+1);
                    for(String neiWord : nei.get(pattern)){
                        if(!vis.contains(neiWord)){
                            vis.add(neiWord);
                            q.add(neiWord);
                        }
                    }
                }
            }
            res += 1;
        }
        return 0;
    }
}
