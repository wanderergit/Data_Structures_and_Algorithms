package graphs.algorithms;

import java.util.*;

class Edge{
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class Pair{
    int index;
    int distance;

    Pair(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}

class PairsComparator implements Comparator<Pair>{

    @Override
    public int compare(Pair p1, Pair p2) {
        if(p1.distance > p2.distance) return 1;
        else if(p2.distance > p1.distance) return -1;
        return 0;
    }
}

public class Dijsktras {
    public static void main(String[] args) {
        /*
            This is an implementation of the Dijkstra's algorithm (Lazy Approach).
            First let's create the graph.
         */

        HashMap<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>();
        //number of vertices
        int v = 5;

        Edge e1 = new Edge(0, 1, 4);
        Edge e2 = new Edge(0, 2, 1);
        Edge e3 = new Edge(2, 1, 2);
        Edge e4 = new Edge(1, 3, 1);
        Edge e5 = new Edge(2, 3, 5);
        Edge e6 = new Edge(3, 4, 3);
        List<Edge> list0 = new ArrayList<>();
        list0.add(e1);
        list0.add(e2);
        graph.put(0, list0);
        List<Edge> list1 = new ArrayList<>();
        list1.add(e4);
        graph.put(1, list1);
        List<Edge> list2 = new ArrayList<>();
        list2.add(e3);
        list2.add(e5);
        graph.put(2, list2);
        List<Edge> list3 = new ArrayList<>();
        list3.add(e6);
        graph.put(3, list3);
        List<Edge> list4 = new ArrayList<>();
        graph.put(4, list4);
        //start Node = 0

        int s = 0;

        //the dijkstras algorithm will return an array of the shortest distance from the starting node to each of the nodes.

        int[] res = dijkstras(graph, v, s);
        System.out.println(Arrays.toString(res));
    }

    public static int[] dijkstras(HashMap<Integer, List<Edge>> graph, int n, int s){
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        //setting all initial values in dist array to be positive infinity
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;
        //we will need a PQ which sorts based on values
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, new PairsComparator());
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            vis[p.index] = true;
            List<Edge> adjacentEdges = graph.get(p.index);
            for(Edge e : adjacentEdges){
                //if already visited to, then ignore
                if(vis[e.to]) continue;
                //perform the relaxation step on the 'to'
                int newDist = dist[p.index] + e.weight;
                if(newDist < dist[e.to]){
                    dist[e.to] = newDist;
                    pq.add(new Pair(e.to, newDist));
                }
            }
        }
        return dist;
    }
}


