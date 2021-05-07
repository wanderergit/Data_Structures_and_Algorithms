package graphs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    For the kruskal MST algorithm, we will create a union find data structure
    In kruskal's, we have to first sort the edges in increasing order of their edge weights
    then, we have to take the smallest edge every time and if they are in different componenets
    we have to merge (union) them, else we have to ignore and continue
 */

class UnionFind {
    int[] parent;
    int[] size;
    int n;

    UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        this.n = n;
    }

    public int find(int p){

        // uncomment this part for the recursive approach
        // we will do this iteratively for 'path compression'

//        if(parent[s1] == s1) return s1;
//        else return find(parent[s1]);

        // finding and storing the root element of p
        int root = p;
        while(root != parent[root]){
            root = parent[root];
        }

        // move along p's path to root and point every node to the root
        while(p!=root){
            int next = parent[p];
            parent[p] = root;
            p = next;
        }

        return root;
    }

    public void union(int s1, int s2){
        int r1, r2;
        r1 = find(s1);
        r2 = find(s2);
        if(r1 == r2) return;
        if(size[r1] >= size[r2]){
            size[r1] = size[r1] + size[r2];
            parent[r2] = r1;
        } else {
            size[r2] = size[r1] + size[r2];
            parent[r1] = r2;
        }
    }

    boolean sameComponent(int s1, int s2){
        return (find(s1) == find(s2));
    }

}

public class KruskalsMST {

    public static void main(String[] args) {
        ArrayList<Edge> arr = new ArrayList<>();
        arr.add(new Edge(0, 1, 4));
        arr.add(new Edge(0, 7, 8));
        arr.add(new Edge(1, 7, 11));
        arr.add(new Edge(7, 6, 1));
        arr.add(new Edge(1, 2, 8));
        arr.add(new Edge(7, 8, 7));
        arr.add(new Edge(2, 8, 2));
        arr.add(new Edge(8, 6, 6));
        arr.add(new Edge(2, 3, 7));
        arr.add(new Edge(2, 5, 4));
        arr.add(new Edge(6, 5, 2));
        arr.add(new Edge(3, 5, 14));
        arr.add(new Edge(3, 4, 9));
        arr.add(new Edge(5, 4, 10));

        // total number of vertices
        int V = 9;

        kruskal(arr, V);
    }

    public static List<Edge> kruskal(ArrayList<Edge> edges, int n){
        List<Edge> inMST = new ArrayList<Edge>();
        int cost = 0;

        // initialise the union find data structure
        UnionFind uf = new UnionFind(n);

        // we will sort the edges by their weights
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for(int i=0; i<edges.size(); i++){
            Edge e = edges.get(i);
            if(!uf.sameComponent(e.from, e.to)){
                System.out.println("-> Insert edge from [" + e.from + " to " + e.to + "] of cost [" + e.weight + "]");
                inMST.add(e);
                cost += e.weight;
                if(inMST.size() == n-1) break;
                uf.union(e.from, e.to);
            }
        }
        System.out.println("*******************");
        System.out.println("The total cost of the MST is : " + cost);
        System.out.println("*******************");
        return inMST;
    }
}
