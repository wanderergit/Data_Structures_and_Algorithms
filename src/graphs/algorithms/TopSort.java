package graphs.algorithms;

// we need unweighted or weighted directed graph
// weights doesn't matter

import java.util.ArrayList;
import java.util.Arrays;

public class TopSort {
    public static boolean[] visited;
    public static int[] topsorted;
    public static int t;
    public static void main(String[] args) {

        GraphEdgeList graph = new GraphEdgeList(5);
        graph.addEdge(0, new Edge(0, 1, 5));
        graph.addEdge(1, new Edge(1, 2, 2));
        graph.addEdge(1, new Edge(1, 3, 6));
        graph.addEdge(2, new Edge(2, 4, 9));
        graph.addEdge(3, new Edge(3, 4, 13));

        // start node
        int s = 0;
        visited = new boolean[5];
        topsorted = new int[5];
        t = 4;
        for(int i=0; i<5; i++){
            if(!visited[i]){
                topsort(s, graph);
            }
        }
        System.out.println("The top-sorted array is : " + Arrays.toString(topsorted));
    }

    public static void topsort(int at, GraphEdgeList graph){
        visited[at] = true;
        ArrayList<Edge> neighbors = graph.get(at);
        for(Edge item : neighbors){
            if(!visited[item.to]){
                topsort(item.to, graph);
            }
        }
        // here we are adding the node to the topsorted array in reverse after we have processed all the neighbors.
        topsorted[t] = at;
        t--;
    }
}
