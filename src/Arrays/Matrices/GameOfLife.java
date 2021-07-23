package Arrays.Matrices;

import java.util.HashMap;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void gameOfLife(int[][] board) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int neighNum = getNeighNum(i, j, board);
                if((neighNum < 2 || neighNum > 3) && board[i][j] == 1){
                    map.put(i+"-"+j, 0);
                } else if(neighNum == 3 && board[i][j] == 0){
                    map.put(i+"-"+j, 1);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map.containsKey(i+"-"+j)){
                    if(map.get(i+"-"+j) == 1){
                        board[i][j] = 1;
                    } else if(map.get(i+"-"+j) == 0) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static int getNeighNum(int i, int j, int[][] board){
        int count = 0;
        for(int k=0; k<8; k++){
            int xx = i + dx[k];
            int yy = j + dy[k];
            if(xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length) continue;
            if(board[xx][yy] == 1) count++;
        }
        return count;
    }
}
