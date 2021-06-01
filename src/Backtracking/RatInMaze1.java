package Backtracking;

import java.util.ArrayList;

public class RatInMaze1 {
    public static void main(String[] args) {
        int N = 4;
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        System.out.println(findPath(m,N));
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if(m[0][0] != 1) return res;
        recurse(m, n, res, "", 0, 0, visited);
        return res;
    }

    public static void recurse(int[][] m, int n, ArrayList<String> res, String temp, int i, int j, boolean[][] visited){

        if(i == n-1 && j == n-1) {
            String a = temp;
            res.add(a);
            return;
        }

        visited[i][j] = true;

        if(i < n-1 && m[i+1][j] == 1 && !visited[i+1][j]) recurse(m, n, res, temp+"D", i+1, j, visited);
        if(j > 0 && m[i][j-1] == 1 && !visited[i][j-1]) recurse(m, n, res, temp+"L", i, j-1, visited);
        if(j < n-1 && m[i][j+1] == 1 && !visited[i][j+1]) recurse(m, n, res, temp+"R", i, j+1, visited);
        if(i > 0 && m[i-1][j] == 1 && !visited[i-1][j]) recurse(m, n, res, temp+"U", i-1, j, visited);

        visited[i][j] = false;
    }
}
