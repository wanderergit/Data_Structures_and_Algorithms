//package graphs.algorithms;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
///*
//    Question - You are trapped in a 2D dungeon and you need to find the quickest way out!
//    The dungeon is composed of unit cubes which may or may not be filled with rock. It takes one minute
//    to move one unit node north, south, east, west. You cannot move diagonally & the maze  is surrounded
//    by solid rock on all sides.
//    Can be solved by keeping track of the number of moves to the end in a BFS traversal
// */
//public class BFSShortestPathDungeon {
//    public static int[] dr = {-1, 1, 0, 0};
//    public static int[] dc = {0, 0, 1, -1};
//    public static int moveCount = 0;
//    public static int nodesInLayer = 1;
//    public static int nodesInNextLayer = 0;
//    public static int R = 5;
//    public static int C = 4;
//    public static void main(String[] args) {
//
//    }
//    //solve method returns the number of moves made to the end, -1 if the end cannot be found.
//    // sr = start row, sc = start column
//    public static int solve(int sr, int  sc,  int e, ArrayList<ArrayList<Edge>> graph){
//        Queue<Integer> rq = new LinkedList<>();
//        Queue<Integer> cq = new LinkedList<>();
//        rq.add(sr);
//        cq.add(sc);
//
//        visitNeighbors(sr, sc);
//
//    }
//
//    // the visit neighbors function will visit all possible neighbors of the given coordinates
//    public static visitNeighbors(int r, int c){
//        for(int i=0; i<4; i++){
//            int rr = r+dr[i];
//            int cc = c+dc[i];
//
//            //check if inside bounds
//            if(rr<0 || cc<0 || rr>=R || cc>=C) continue;
//            //check if hit rock
//            if(maze[rr][cc] == '#') continue;
//
//            nodesInNextLayer++;
//        }
//    }
//}
