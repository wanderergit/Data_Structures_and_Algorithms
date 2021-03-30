package Tries.Problems;

import java.util.ArrayList;

public class UniqueRowsInBinaryMatrix {
    int[][] arr = {{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}};
    Solver obj = new Solver();
    ArrayList<ArrayList<Integer>> res = obj.uniqueRow(arr, arr.length, arr[0].length);
    //print here
}
class Solver
{
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int wordEnd;
        TrieNode() {
            for(TrieNode child : children)
                child = null;
            wordEnd = 0;
        }
    }

    TrieNode root;

    ArrayList<ArrayList<Integer>> arrList;

    public void insert(int[] arr){
        int level, index;
        int length = arr.length;
        TrieNode pCrawl = root;
        for(level=0; level<length; level++){
            index = arr[level];
            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        if(pCrawl.wordEnd == 0){
            pCrawl.wordEnd = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int item : arr)
                temp.add(item);
            arrList.add(temp);
        }
    }

    public ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        //trie solution
        //we can add all the rows in a trie
        //if wordEnd value is already 1, that means word is already present
        //so don't output that into the ArrayList, output when wordEnd is freshly made 1

        root = new TrieNode();
        arrList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<r; i++){
            insert(a[i]);
        }

        return arrList;


    }
}