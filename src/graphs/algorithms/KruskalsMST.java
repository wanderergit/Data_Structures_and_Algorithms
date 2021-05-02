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

    public int find(int s1){
        if(parent[s1] == s1) return s1;
        else return find(parent[s1]);
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

    }
    public static List<Edge> kruskal(ArrayList<Edge> edges, int n){
        List<Edge> inMST = new ArrayList<Edge>();
        int cost = 0;
        // initialise the union find data structure
        UnionFind uf = new UnionFind(n);
        // we will the edges by their weights
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for(int i=0; i<edges.size(); i++){
            Edge e = edges.get(i);
            if(!uf.sameComponent(e.from, e.to)){
                System.out.println("edge from " + e.from + " to " + e.to + " is part of MST");
                inMST.add(e);
                uf.union(e.from, e.to);
                cost += e.weight;
            }
        }
        System.out.println("The total cost of the MST is : " + cost);
        return inMST;
    }
}
