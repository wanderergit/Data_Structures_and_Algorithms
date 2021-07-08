package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {
    static class Coordinates{
        int r;
        int c;
        int dist;
        Coordinates(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int src[] = {4, 5};
        int dest[] = {1, 1};
        int N = 6;
        System.out.println(minStepToReachTarget(src, dest, N));
    }
    static int[] dr = {-1, -1, 1, 1, 2, 2, -2, -2};
    static int[] dc = {2, -2, 2, -2, 1, -1, 1, -1};
    public static int minStepToReachTarget(int src[], int target[], int N)
    {
        // we can have a getValidMoves function which return the valid neighbors of
        // the knight's position.

        // we can use bfs because this is an unwighted graph, all moves have equal weights
        // using bfs, we will count the shortest distance in undirected graph.
        if(src[0] == target[0] && src[1] == target[1]) return 0;
        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(src[0], src[1], 0));
        boolean visited[][] = new boolean[N+1][N+1];
        visited[src[0]][src[1]] = true;
        while(!q.isEmpty()){
            Coordinates curr = q.remove();
            ArrayList<Coordinates> neighbors = getValidMoves(curr, N);
            for(Coordinates item : neighbors){
                if(item.r == target[0] && item.c == target[1]) return item.dist;
                if(!visited[item.r][item.c]){
                    visited[item.r][item.c] = true;
                    q.add(item);
                }
            }
        }
        return -1;
    }

    public static ArrayList<Coordinates> getValidMoves(Coordinates curr, int N){
        ArrayList<Coordinates> res = new ArrayList<>();

        // check valid moves for all 8 moves...
        for(int i=0 ;i<8; i++){
            int r = curr.r + dr[i];
            int c = curr.c + dc[i];
            //checking if within bounds (1-based indexing)...
            if(r>N || c>N || r<=0 || c<=0) continue;
            res.add(new Coordinates(r, c, curr.dist + 1));
        }
        return res;
    }
}
