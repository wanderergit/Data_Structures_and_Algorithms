package graphs.algorithms;

import java.util.ArrayList;

public class FloydWarshallAllPairShortestPath {
    public static void main(String[] args){
        // the best representation for FW is matrix form graph
        double POSINF = Double.POSITIVE_INFINITY;
        double[][] graph = {{0, 1, 1, POSINF, POSINF, POSINF},
                {1, 0, POSINF, 1, POSINF, POSINF},
                {1, POSINF, 0, 1, 1, POSINF},
                {POSINF, 1, 1, 0, POSINF, 1},
                {POSINF, POSINF, 1, POSINF, 0, 1},
                {POSINF, POSINF, POSINF, 1, 1, 0}};

        int R = graph.length;
        int C = graph[0].length;

        double[][] dp = new double[R][C];
        int[][] next = new int[R][C];

        // perform a deep-copy of graph in matrix
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                dp[i][j] = graph[i][j];
                if(graph[i][j] != POSINF){
                    next[i][j] = j;
                }
            }
        }

        // execute FW
        for(int k=0; k<R; k++){
            for(int i=0; i<R; i++){
                for(int j=0; j<R; j++){
                    if(dp[i][k] + dp[k][j] < dp[i][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // propagate negative cycles
        for(int k=0; k<R; k++){
            for(int i=0; i<R; i++){
                for(int j=0; j<R; j++){
                    if(dp[i][k] + dp[k][j] < dp[i][j]){
                        dp[i][j] = Double.NEGATIVE_INFINITY;
                        next[i][j] = -1;
                    }
                }
            }
        }

        // printing out dp which gives all pairs shortest path
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        printShortestPath(1, 4, dp, next);

    }

    public static void printShortestPath(int start, int end, double[][] dp, int[][] next){
        ArrayList<Integer> path = new ArrayList<>();
        if(dp[start][end] == Double.POSITIVE_INFINITY) System.out.println(path);

        int at = start;
        for(; at != end; at = next[at][end]){
            if(at == -1) break;
            path.add(at);
        }

        if(next[at][end] == -1) System.out.println("No path");
        path.add(end);
        System.out.println("Path : " + path);
    }
}
