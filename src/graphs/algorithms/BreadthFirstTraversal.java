package graphs.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
This program is BFS + Count the connected components + Two Coloring of Graph
 */
public class BreadthFirstTraversal {
    static boolean visited[];
    static boolean isTwoColored = true;
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        GraphEdgeList graph = new GraphEdgeList(6);
        graph.addEdge(0, new Edge(0, 1, 5));
        graph.addEdge(0, new Edge(0, 2, 50));
        graph.addEdge(1, new Edge(1, 2, 2));
        graph.addEdge(1, new Edge(1, 3, 6));
        graph.addEdge(2, new Edge(2, 4, 9));
        graph.addEdge(3, new Edge(3, 4, 13));

        int V = graph.V;
        visited = new boolean[V];
        res = new ArrayList<>(V);
        /*
        Let's assume 0 to be not yet colored, 1 and 2 to be two different colors
         */
        int coloring[] = new int[V];
        /*
        this counter is for the connected components
         */
        int count = 0;
        for(int i=0; i<V; i++){
            if(!visited[i]){
                bft(graph, i, coloring);
                count++;
            }
        }


        System.out.println("The BFT result is : " + res.toString());
        System.out.println("The number of connected components is : " + count);
        if(isTwoColored) System.out.println("The graph is two-colored");
        else System.out.println("the graph is not two colored");
    }
    public static void bft(GraphEdgeList graph, int at, int[] coloring){
        visited[at] = true;
        res.add(at);
        Queue<Integer> q = new LinkedList<>();
        q.add(at);
        // this will apply only to the start node
        if(coloring[at] == 0) coloring[at] = 1;
        while(!q.isEmpty()){
            int curr = q.remove();
            ArrayList<Edge> edges = graph.get(curr);
            for(Edge edge : edges){
                //checking if the to node has not been explored yet, then color it in complementary color
                //if already explored make sure that it isn't the same color as the from node
                //if they are the same color then graph is not two colored
                if(coloring[curr] == 1 && coloring[edge.to] == 0) coloring[edge.to] = 2;
                else if(coloring[curr] == 2 && coloring[edge.to] == 0 ) coloring[edge.to] = 1;
                else if(coloring[edge.to] == coloring[curr]) isTwoColored = false;
                if(!visited[edge.to]){
                    visited[edge.to] = true;
                    q.add(edge.to);
                    res.add(edge.to);
                }
            }
        }
    }
}
