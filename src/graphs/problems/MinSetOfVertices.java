package graphs.problems;

import java.util.ArrayList;
import java.util.List;

/*
    1557. Minimum Number of Vertices to Reach All Nodes - LeetCode

Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
Notice that you can return the vertices in any order.

 */
public class MinSetOfVertices {
    /*
        the idea is to mark nodes who has an indegree of zero, those nodes are the ones which will give us the
        min set of vertices
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] indegree = new boolean[n];
        for (List<Integer> edge : edges) {
            // if any vertex in the to section of an edge, that vertex has a positive indegree
            indegree[edge.get(1)] = true;
        }
        // if indegree is still 0, add to result
        for (int i = 0; i < n; i++) {
            if (!indegree[i]) {
                res.add(i);
            }
        }
        return res;

    }
    public static void main(String[] args) {

    }
}
