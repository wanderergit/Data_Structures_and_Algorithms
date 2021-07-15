package Tries.Problems;

public class WordBreak {

    static class TrieNode{
        static final int ALPHABETS = 26;

        boolean wordEndingHere;
        TrieNode[] children = new TrieNode[ALPHABETS];

        TrieNode(){
            wordEndingHere = false;
            for(int i=0; i<ALPHABETS; i++){
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key){

        TrieNode pCrawl = root;
        int length = key.length();
        int level;
        int index;

        for(level = 0; level < length; level++){
            index = key.charAt(level)-'a';
            if(pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.wordEndingHere = true;
    }

    static boolean search(String key){
        TrieNode pCrawl = root;
        int index;
        int level;
        int length = key.length();

        for(level = 0; level<length; level++){
            index = key.charAt(level)-'a';
            if(pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.wordEndingHere);
    }

    static boolean delete(String key){
        TrieNode pCrawl = root;
        int index;
        int level;
        int length = key.length();

        for(level = 0; level<length; level++){
            index = key.charAt(level)-'a';
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

    public static boolean wordBreak(int start, int end, String word, TrieNode root){

        int size = word.length();

        if(size == 0)
            return true;

        for(int i=1; i<=size; i++){
            if(search(word.substring(0, i)) && wordBreak(i, end, word.substring(i, size), root))
                return true;
        }
        return false;

    }

    public static void main(String[] args){
        root = new TrieNode();
        insert("i");
        insert("like");
        insert("sam");
        insert("sung");
        insert("samsung");
        insert("mobile");
        insert("ice");
        insert("cream");
        insert("icecream");
        insert("man");
        insert("go");
        insert("mango");

        String word = "ilikesamsung";

        System.out.println(wordBreak(0, word.length()-1, word, root));

    }

}
