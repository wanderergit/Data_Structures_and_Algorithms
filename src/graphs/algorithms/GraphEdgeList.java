package graphs.algorithms;

import java.util.ArrayList;

public class GraphEdgeList {

    ArrayList<ArrayList<Edge>> graph;
    int V;
    int E;

    GraphEdgeList(int n) {
        graph = new ArrayList<>(n);
        for(int i =0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        V = n;
        E = 0;
    }

    //the add edge function takes in two params, the index at which we have to add and the edge we have to add
    //note that the edge is essentially a pair (to, weight), as 'from' is implicit from the graph index
    public void addEdge(int index, Edge item){
        graph.get(index).add(item);
        E = E+1;
    }

    public void removeEdge(int index, Edge item){
        graph.get(index).remove(item);
        E = E-1;
    }

    public ArrayList<Edge> get(int index){
        return graph.get(index);
    }

    public void printGraph(){
        for(int i=0; i<V; i++){
            System.out.print("["+i+"] -> ");
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j).toString() + " -> ");
            }
            System.out.println();
        }
    }
}

class Demo {
    public static void main(String[] args) {
        GraphEdgeList graph = new GraphEdgeList(5);
        graph.addEdge(0, new Edge(0, 1, 5));
        graph.addEdge(1, new Edge(1, 2, 2));
        graph.addEdge(1, new Edge(1, 3, 6));
        graph.addEdge(2, new Edge(2, 4, 9));
        graph.addEdge(3, new Edge(3, 4, 13));
        graph.printGraph();
    }
}
