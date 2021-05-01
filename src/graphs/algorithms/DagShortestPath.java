package graphs.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class DagShortestPath {
    public static void main(String[] args) {
        GraphEdgeList graph = new GraphEdgeList(5);
        graph.addEdge(0, new Edge(0, 1, 5));
        graph.addEdge(1, new Edge(1, 2, 2));
        graph.addEdge(1, new Edge(1, 3, 6));
        graph.addEdge(2, new Edge(2, 4, 9));
        graph.addEdge(3, new Edge(3, 4, 13));

        int[] res = dagShortestPath(0, graph);
        System.out.println("the shortest distance in this dag is : " + Arrays.toString(res));
    }

    public static int[] dagShortestPath(int at, GraphEdgeList graph){
        boolean[] visited = new boolean[5];
        int[] topsorted = topsort(at, graph, visited);
        int[] dist = new int[topsorted.length];
        for(int i=0; i< dist.length; i++) dist[i] = Integer.MAX_VALUE;
        dist[at] = 0;

        for(int i=0; i< topsorted.length; i++){
            ArrayList<Edge> neighbors = graph.get(i);
            for(Edge e : neighbors){
                if(dist[at] + e.weight < dist[e.to])
                    dist[e.to] = dist[at] + e.weight;
            }
        }

        return dist;
    }

    static int i = 4;
    static int res[] = new int[5];

    public static int[] topsort(int at, GraphEdgeList graph, boolean[] visited){

        visited[at] = true;
        ArrayList<Edge> edges = graph.get(at);
        for(Edge e : edges){
            if(!visited[e.to]){
                topsort(e.to, graph, visited);
            }
        }
        res[i] = at;
        i--;
        return res;
    }
}
