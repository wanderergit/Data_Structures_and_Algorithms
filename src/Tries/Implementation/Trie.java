package Tries.Implementation;

public class Trie {

    //we have to first make a trie node with a class TrieNode
    static final int ALPHABETS = 26;

    static class TrieNode {
        //we need an array to store TrieNodes and then a wordEndingHere variable
        TrieNode[] children = new TrieNode[ALPHABETS];
        boolean wordEndingHere;

        TrieNode() {
            wordEndingHere = false;
            for(int i=0; i<ALPHABETS; i++){
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key){
        //we need to maintain the level we are on and the index;
        int length = key.length();
        int level;
        int index;
        //we also need a pCrawl to store the reference as we go
        TrieNode pCrawl = root;
        for(level = 0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.wordEndingHere = true;
    }

    static boolean search(String key){
        //we need to maintain the level we are on and the index;
        int length = key.length();
        int level;
        int index;
        //we also need a pCrawl to store the reference as we go
        TrieNode pCrawl = root;
        for(level = 0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.wordEndingHere);
    }

    static boolean delete(String key){
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;
        for(level = 0; level<length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        if(pCrawl != null && pCrawl.wordEndingHere){
            pCrawl.wordEndingHere = false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        root = new TrieNode();

        String[] keys = {"hey", "hi", "bye", "bring", "apple", "appetite", "a"};
        for(String key : keys){
            insert(key);
        }

        System.out.println(search("hey"));
//        System.out.println(search("oye"));
//        System.out.println(search("hill"));
//        System.out.println(search("hi"));
//        System.out.println(search("h"));
//        System.out.println(search("appetite"));
        System.out.println(delete("hey"));
        System.out.println(search("hey"));

    }

}
