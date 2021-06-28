package graphs.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class CheckBipartite {

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int[] color = new int[V];
        Queue<Integer> q = new LinkedList<>();
        boolean isBlack = true;
        // if graph is disconnected, loop through all vertices
        for(int i=0; i<V; i++){
            // if vertex is uncolored
            if(color[i] == 0){
                q.add(i);
                while(!q.isEmpty()){
                    int n = q.size();
                    for(int j=0; j<n; j++){
                        int curr = q.poll();
                        color[curr] = (isBlack) ? 1 : 2;
                        // for each neighbor of current vertex
                        for(int neighbor : adj.get(curr)){
                            if(color[neighbor] == 0)
                                q.add(neighbor);
                            else if(color[neighbor] == color[curr])
                                return false;
                        }
                    }
                    // after the layer, change the color to its complement
                    isBlack = !isBlack;
                }
            }
        }
        System.out.println(Arrays.toString(color));
        return true;
    }

    public static void main(String[] args) {
        int V, E;
        V = 4 ;
        E = 8;

        // adjacency list for storing graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(0);
        adj.get(3).add(2);

        boolean ans = isBipartite(V, adj);
        System.out.println(ans);
    }
}
