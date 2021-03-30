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

    public static String getShortestUniquePrefix(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        StringBuffer res = new StringBuffer("");
        for(level=0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.prefCount == 1)
                return res.toString();
            if(pCrawl.children[index] == null)
                return "";
            pCrawl = pCrawl.children[index];
            res.append(key.charAt(level));
        }
        if(pCrawl != null)
            return res.toString();
        return "";
    }

    public static void main(String[] args) {
        root = new TrieNode();
//        insert("abac");
//        insert("abaa");
//        insert("abab");
//        insert("aabb");
//        insert("aabc");
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(String item : arr)
            insert(item);
        for(String item: arr)
            System.out.println(getShortestUniquePrefix(item));
    }

}


