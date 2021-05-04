//package graphs.problems;
//
//import java.util.ArrayList;
//import java.util.List;
//
///*
//    https://www.geeksforgeeks.org/find-whether-it-is-possible-to-finish-all-tasks-or-not-from-given-dependencies/
//    There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites, for example to pick task 0 you have to first pick task 1, which is expressed as a pair: [0, 1]
//    Given the total number of tasks and a list of prerequisite pairs, is it possible for you to finish all tasks?
//
//    Thinkng 1 : I am thinking of the Union Find DS.
//    Why this approach will not work : this is a directed graph here and Union Find cannot be used to detect cycles
//    in a directed graph, it can only detect cycles in undirected graph
//
//    Solution : I think converting it into a directed adj list and then running DFS to detect cycles will do the trick.
// */
//public class DependenciesGFG {
//
//    static class Edge{
//        int from;
//        int to;
//        Edge(int f, int t){
//            from = f;
//            to = t;
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 4;
//        int[][] arr = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
//        System.out.println(solve(arr, n));
//    }
//
//    public static boolean solve(int[][] arr, int n){
//        // create a adj list
//        List<List<Edge>> list = new ArrayList<List<Edge>>();
//        Edge[] = {
//                new Edge()
//        }
//    }
//}
