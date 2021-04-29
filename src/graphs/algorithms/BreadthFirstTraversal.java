package graphs.algorithms;

import java.util.*;

public class BreadthFirstTraversal {
    static boolean visited[];
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        GraphEdgeList graph = new GraphEdgeList(5);
        graph.addEdge(0, new Edge(0, 1, 5));
        graph.addEdge(1, new Edge(1, 2, 2));
        graph.addEdge(1, new Edge(1, 3, 6));
        graph.addEdge(2, new Edge(2, 4, 9));
        graph.addEdge(3, new Edge(3, 4, 13));

        int V = graph.V;
        visited = new boolean[V];
        res = new ArrayList<>(V);
        for(int i=0; i<V; i++){
            if(!visited[i]){
                bft(graph, i);
            }
        }

        System.out.println("The BFT result is : " + res.toString());
    }
    public static void bft(GraphEdgeList graph, int at){
        visited[at] = true;
        res.add(at);
        Queue<Integer> q = new LinkedList<>();
        q.add(at);
        while(!q.isEmpty()){
            int curr = q.remove();
            ArrayList<Edge> edges = graph.get(curr);
            for(Edge edge : edges){
                if(!visited[edge.to]){
                    visited[edge.to] = true;
                    q.add(edge.to);
                    res.add(edge.to);
                }
            }
        }
    }
}
