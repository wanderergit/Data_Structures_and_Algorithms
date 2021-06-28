package graphs.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordEdgeList {
    public static void main(String[] args) {
        //number of edges and vertices; and the starting node index S
        int v = 10;
        int s = 0;
        //create all the edges
        Edge e1 = new Edge(0, 1, 5);
        Edge e2 = new Edge(1, 2, 20);
        Edge e3 = new Edge(2, 3, 10);
        Edge e4 = new Edge(3, 2, -15);
        Edge e5 = new Edge(1, 5, 30);
        Edge e6 = new Edge(5, 4, 25);
        Edge e7 = new Edge(2, 4, 75);
        Edge e8 = new Edge(4, 9, 100);
        Edge e9 = new Edge(1, 6, 60);
        Edge e10 = new Edge(5, 6, 5);
        Edge e11 = new Edge(6, 7, -50);
        Edge e12 = new Edge(5, 8, 50);
        Edge e13 = new Edge(7, 8, 10);
        //insert all the edges into the edgelist implementation of the graph
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
        edges.add(e7);
        edges.add(e8);
        edges.add(e9);
        edges.add(e10);
        edges.add(e11);
        edges.add(e12);
        edges.add(e13);

        //we will pass this to the bf implementation function which will distance array from the start node to every other node
        //in the distance array, if there is a negative cycle the algo will mark the distance as negative infinity
        double[] res = bellmanFord(edges, v, s);
        System.out.println(Arrays.toString(res));
    }

    public static double[] bellmanFord(ArrayList<Edge> edges, int v, int s){
        //initialise the dist. array
        double[] dist = new double[v];
        for(int i=0; i<v; i++)
            dist[i] = Double.POSITIVE_INFINITY;
        dist[s] = 0;

        //loop V-1 times and relax each edge in the graph
        for(int i=0; i<v-1; i++){
            for(Edge edge : edges){
                //relaxation step
                if(dist[edge.from] + edge.weight < dist[edge.to]){
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        //to detect negative cycles
        for(int i=0; i<v-1; i++){
            for(Edge edge : edges){
                //if after finding the final distance, we have negative cycles. We will encounter another decrease
                //such a decrease will lead to an infinite loop
                if(dist[edge.from] + edge.weight < dist[edge.to]){
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                }
            }
        }

        return dist;
    }
}
