package Tries.Problems;

public class NumberOfStringsWithGivenPrefix {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int prefCount;
        TrieNode() {
            for(TrieNode child : children){
                child = null;
            }
            prefCount = 0;
        }
    }

    static TrieNode root;

    public static void insert(String key){
        int length = key.length();
        int level;
        int index;
        TrieNode pCrawl = root;
        for(level = 0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
            pCrawl.prefCount += 1;
        }
    }

    public static int countStringsCommonPrefix(String pref){
        int level;
        int length = pref.length();
        int index;
        TrieNode pCrawl = root;
        for(level=0; level<length; level++){
            index = pref.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                return 0;
            pCrawl = pCrawl.children[index];
        }
        if(pCrawl != null)
            return pCrawl.prefCount;
        return 0;
    }

    public static void main(String[] args) {
        root = new TrieNode();
        insert("abac");
        insert("abaa");
        insert("abab");
        insert("aabb");
        insert("aabc");
        System.out.println(countStringsCommonPrefix("h"));
    }

}


