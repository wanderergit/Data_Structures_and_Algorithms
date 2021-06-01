package Backtracking;

public class KnightsTour {
    public static void main(String[] args) {
        int n = 8;
        int[][] res = findKnightTour(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean found = false;
    public static int[][] findKnightTour(int n){

        int[][] grid = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        recurse(0,0,0,grid, n,visited);
        return grid;

    }

    public static void recurse(int x, int y, int hop, int[][] grid,int n, boolean[][] visited) {
        // System.out.println(" I Am AT row : " + x + " and col : " + y + " and the value of hop is : " + hop);
        visited[x][y] = true;
        grid[x][y] = hop;
        if (hop == (n*n)-1) {
            found = true;
            return;
        }
        // check all 8 possible cases
        if (isValidHop(x + 2, y + 1, n, visited)) recurse(x + 2, y + 1, hop + 1, grid, n, visited);
        if (isValidHop(x + 1, y + 2, n, visited)) recurse(x + 1, y + 2, hop + 1, grid, n, visited);
        if (isValidHop(x - 1, y + 2, n, visited)) recurse(x - 1, y + 2, hop + 1, grid, n, visited);
        if (isValidHop(x - 2, y + 1, n, visited)) recurse(x - 2, y + 1, hop + 1, grid, n, visited);
        if (isValidHop(x - 2, y - 1, n, visited)) recurse(x - 2, y - 1, hop + 1, grid, n, visited);
        if (isValidHop(x - 1, y - 2, n, visited)) recurse(x - 1, y - 2, hop + 1, grid, n, visited);
        if (isValidHop(x + 1, y - 2, n, visited)) recurse(x + 1, y - 2, hop + 1, grid, n, visited);
        if (isValidHop(x + 2, y - 1, n, visited)) recurse(x + 2, y - 1, hop + 1, grid, n, visited);


        //set visited back to false for other cases to visit this cell
        visited[x][y] = false;

    }

    public static boolean isValidHop(int x, int y, int n, boolean[][] visited){
        if(x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || found) return false;
        return true;
    }

}
