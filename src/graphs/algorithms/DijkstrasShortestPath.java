package graphs.algorithms;

import java.util.*;

public class DijkstrasShortestPath {
    public static int[] prev;
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
        int e = 4;
        //the dijkstras algorithm will return an array of the shortest distance from the starting node to each of the nodes.
        Object[] res = dijkstrasShortestPath(graph, v, s, e);
        System.out.println(Arrays.toString(res));
    }

    public static Object[] dijkstrasShortestPath(HashMap<Integer, List<Edge>> graph, int n, int s, int e){
        int[] dist = dijkstras(graph, n, s, e);
        //here we have the updated prev array global variable
        //we need to initialise path and go in reverse
        ArrayList<Integer> path = new ArrayList<>();
        for(int at = e; ;at=prev[at]){
            path.add(at);
            //the prev of the root will also be 0 because it was initialised to 0; so break;
            if(at == prev[at]){
                break;
            }
        }
        Collections.reverse(path);
        return path.toArray();
    }

    public static int[] dijkstras(HashMap<Integer, List<Edge>> graph, int n, int s, int end){
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        //initialising the prev array
        prev = new int[n];
        //setting all initial values in dist array to be positive infinity
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;
        //we will need a PQ which sorts based on values
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, new PairsComparator());
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            vis[p.index] = true;
            /*
                Uncomment this for a neat optimisation
                this ignores those nodes where the distance array already holds a lower value than p.distance
                if(dist[p.index] < p.distance) continue;
             */
            List<Edge> adjacentEdges = graph.get(p.index);
            for(Edge e : adjacentEdges){
                //if already visited to, then ignore
                if(vis[e.to]) continue;
                //perform the relaxation step on the 'to'
                int newDist = dist[p.index] + e.weight;
                if(newDist < dist[e.to]){
                    dist[e.to] = newDist;
                    prev[e.to] = p.index;
                    pq.add(new Pair(e.to, newDist));
                }
            }
            //optimisation because if we have already reached a node, we can return it if that is the end node
            //the algorithm would have already found the shortest distance to that node at that point and there is no
            //need to go further.
            if(p.index == end) return dist;
        }
        return dist;
    }
}