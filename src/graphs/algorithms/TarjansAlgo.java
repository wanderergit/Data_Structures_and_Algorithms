package graphs.algorithms;

import java.util.*;

/*
    gfg - Strongly connected component (Tarjans's Algo)
 */
public class TarjansAlgo {
    int UNVISITED = -1;
    int id = 0;

    int[] ids;
    int[] low;
    boolean onStack[];
    Stack<Integer> st;
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ids = new int[V];
        Arrays.fill(ids, UNVISITED);
        low = new int[V];
        onStack = new boolean[V];
        st = new Stack<>();
        res = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(ids[i] == UNVISITED){
                dfs(i, adj);
            }
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(0) - b.get(0);
            }
        });
        return res;
    }

    public void dfs(int at, ArrayList<ArrayList<Integer>> adj){
        st.push(at);
        onStack[at] = true;
        ids[at] = id;
        low[at] = id;
        id++;

        for(int to : adj.get(at)){
            if(ids[to] == UNVISITED) dfs(to, adj);
            if(onStack[to]) low[at] = Math.min(low[at], low[to]);
        }

        // if at start of an scc
        if(ids[at] == low[at]){
            ArrayList<Integer> li = new ArrayList<>();
            for(int node = st.pop(); ;node = st.pop()){
                onStack[node] = false;
                low[node] = ids[at];
                li.add(0, node);
                if(node == at) break;
            }
            Collections.sort(li);
            res.add(0, li);
        }

    }
}
