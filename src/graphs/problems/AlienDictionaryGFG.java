package graphs.problems;
/*
    https://practice.geeksforgeeks.org/problems/alien-dictionary/1
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionaryGFG {
    static class Node{
        char ele;
        ArrayList<Node> neighbors;
        int indegree;
        Node(char ele){
            this.ele = ele;
            neighbors = new ArrayList<>();
            indegree = 0;
        }
    }
    static class Solution
    {
        public String findOrder(String [] dict, int N, int K)
        {
            // Write your code here

            //creating the nodes
            Node[] nodes = new Node[K];
            for(int i=0; i<K; i++){
                char c = (char) (97-i);
                nodes[i] = new Node(c);
            }

            // create edges between the nodes
            for(int i=0; i<N-1; i++){
                String curr = dict[i];
                String next = dict[i+1];
                for(int x=0; x<curr.length() && x<next.length(); x++){
                    // if it is the same character
                    if(curr.charAt(x) == next.charAt(x)) continue;
                    else{
                        nodes[(int)curr.charAt(x)-97].neighbors.add(nodes[(int)next.charAt(x)-97]);
                        nodes[(int)next.charAt(x)-97].indegree++;
                        break;
                    }
                }
            }

            //find toposort

            return topoSort(nodes, K);

        }
        boolean visited[];
        public String topoSort(Node[] nodes, int K){
            String res = "";
            Queue<Node> q = new LinkedList<>();
            for(int i=0; i<K; i++){
                if(nodes[i].indegree == 0)
                    q.add(nodes[i]);
            }
            while(!q.isEmpty()){
                Node curr = q.remove();
                res += curr.ele;
                for(Node item : curr.neighbors){
                    item.indegree -= 1;
                    if(item.indegree == 0){
                        q.add(item);
                    }
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        String[]  dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(obj.findOrder(dict, 5, 4));
    }
}





