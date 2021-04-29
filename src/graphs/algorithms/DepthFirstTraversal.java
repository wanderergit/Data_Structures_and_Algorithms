package graphs.algorithms;

import java.util.ArrayList;

public class DepthFirstTraversal {
    static boolean visited[];
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        GraphEdgeList graph = new GraphEdgeList(5);
        graph.addEdge(0, new Edge(0, 1, 5));
        graph.addEdge(1, new Edge(1, 2, 2));
        graph.addEdge(1, new Edge(1, 3, 6));
        graph.addEdge(2, new Edge(2, 4, 9));
        graph.addEdge(3, new Edge(3, 4, 13));

        int start = 0;
        int V = graph.V;
        visited = new boolean[V];
        res = new ArrayList<>(V);
        for(int i=0; i< graph.V; i++){
            if(!visited[i]){
                dft(graph, i);
            }
        }
        System.out.println("The DFT result is : " + res.toString());
    }
    public static void dft(GraphEdgeList graph, int at){
        visited[at] = true;
        res.add(at);
        ArrayList<Edge> edges = graph.get(at);
        for(Edge edge : edges){
            if(visited[edge.to])continue;
            dft(graph, edge.to);
        }
    }
}
