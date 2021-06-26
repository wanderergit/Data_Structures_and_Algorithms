package graphs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumStepsByKnight {
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(minSteps(6, new Point(4, 5), new Point(1, 1)));
    }

    static int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

    public static int minSteps(int N, Point knight, Point target){

        Queue<Point> q = new LinkedList<>();
        if(knight.x == target.x && knight.y == target.y){
            return 0;
        }
        int steps = 0;
        q.add(knight);
        int flag = 0;
        boolean[][] visited = new boolean[N+1][N+1];
        visited[knight.x][knight.y] = true;

        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Point curr = q.remove();
                System.out.println("x : " + curr.x + " y : " + curr.y);
                if (curr.x == target.x && curr.y == target.y) {
                    flag = 1;
                    break;
                }
                ArrayList<Point> neighbors = getValidNeighbors(curr, N);
                for (Point p : neighbors) {
                    if (!visited[p.x][p.y]) {
                        q.add(p);
                        visited[p.x][p.y] = true;
                    }
                }
            }
            if(flag == 1) break;
            System.out.println(">>> Layer over");
            steps++;
        }
        return (flag == 1) ? steps : -1;
    }

    public static ArrayList<Point> getValidNeighbors(Point curr, int N){
        ArrayList<Point> res = new ArrayList<>();
        for(int i=0; i<8; i++){
            int xx = curr.x + dx[i];
            int yy = curr.y + dy[i];
            if(xx < 0 || xx >= N || yy < 0 || yy >=N) continue;
            res.add(new Point(xx, yy));
        }
        return res;
    }

}
