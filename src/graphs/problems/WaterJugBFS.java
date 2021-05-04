package graphs.problems;
/*
https://www.geeksforgeeks.org/water-jug-problem-using-bfs/
You are given a m liter jug and a n liter jug. Both the jugs are initially empty. The jugs don’t have markings to allow measuring smaller quantities. You have to use the jugs to measure d liters of water where d is less than n.

(X, Y) corresponds to a state where X refers to amount of water in Jug1 and Y refers to amount of water in Jug2
Determine the path from initial state (xi, yi) to final state (xf, yf), where (xi, yi) is (0, 0) which indicates both Jugs are initially empty and (xf, yf) indicates a state which could be (0, d) or (d, 0).

The operations you can perform are:

Empty a Jug, (X, Y)->(0, Y) Empty Jug 1
Fill a Jug, (0, 0)->(X, 0) Fill Jug 1
Pour water from one jug to the other until one of the jugs is either empty or full, (X, Y) -> (X-d, Y+d)
Examples:

Input : 4 3 2
Output : {(0, 0), (0, 3), (4, 0), (4, 3),
          (3, 0), (1, 3), (3, 3), (4, 2),
          (0, 2)}
Solution :

Treat every stage of (xi, yi) as a node in a graph, from any given point we will have 6 different paths to take
explore valid paths using BFS

 */


import java.util.Scanner;
import java.util.List;

public class WaterJugBFS {
    static List<List<Integer>> result;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input the capacity of m, n, and the final state d to measure.
        int m = sc.nextInt();
        int n = sc.nextInt();
        int d = sc.nextInt();
        visited = new boolean[m][n];
        bfs(0, 0, d);
    }

    public static void bfs(int x, int y, int d){
        visited[x][y] = true;
        List<List<Integer>> adjStates = getAdjacentStates(x, y);
        int n = adjStates.size();
        for(int i=0; i<n; i++){
            if((x == d && y == 0) || (y == d && x == 0)){
                System.out.println("We have found the sequence");
            }
            if(!visited[adjStates.get(i).get(0)][adjStates.get(i).get(1)]){

                bfs(adjStates.get(i).get(0), adjStates.get(i).get(1), d);
            }
        }
    }

    public static List<List<Integer>> getAdjacentStates(int x, int y){

        return result;
    }
}
