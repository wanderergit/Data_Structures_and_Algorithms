package graphs.problems;

/*
    https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution obj = new Solution();
        char[][] grid = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        System.out.println(obj.numIslands(grid));
        char[][] grid2 = {{'0','1','1','1','0','0','0'},{'0','0','1','1','0','1','0'}};
        System.out.println(obj.numIslands(grid2));
    }
}


class Pair{
    int x;
    int y;
    Pair(int r, int c){
        x = r;
        y = c;
    }
}

class Solution
{
    //Function to find the number of islands.

    int[] dr = {-1, -1, 1, 1, 0, 0, -1, 1};
    int[] dc = {-1, 1, -1, 1, 1, -1, 0, 0};
    int count;
    boolean[][] visited;

    public int numIslands(char[][] grid)
    {
        int R = grid.length;
        int C = grid[0].length;
        visited = new boolean[R][C];
        count = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(new Pair(i, j), grid, R, C);
                    count += 1;
                }
            }
        }
        return count;
    }

    public void bfs(Pair curr, char[][] grid, int R, int C){
        Queue<Pair> q = new LinkedList<>();
        q.add(curr);
        visited[curr.x][curr.y] = true;
        while(!q.isEmpty()){
            Pair item = q.remove();
            ArrayList<Pair> neighbors = getNeighbors(item, R, C);
            for(Pair ele : neighbors){
                if(!visited[ele.x][ele.y] && grid[ele.x][ele.y] == '1'){
                    q.add(ele);
                    visited[ele.x][ele.y] = true;
                }
            }
        }
    }

    public ArrayList<Pair> getNeighbors(Pair p, int R, int C){
        ArrayList<Pair> res = new ArrayList<>();
        for(int i=0; i<8; i++){
            int r = p.x + dr[i];
            int c = p.y + dc[i];
            if(r>=R || c>=C || r<0 || c<0) continue;
            res.add(new Pair(r, c));
        }
        return res;
    }
}
