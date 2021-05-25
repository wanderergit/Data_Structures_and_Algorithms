package DynamicProgramming.problems;

public class GoldMiner {
    public static void main(String[] args) {
        int[][] M = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
        System.out.println(maxGold(4, 4, M));
    }

    static int maxGold(int m, int n, int M[][]) {
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                M[i][j] += getMaxNeighbors(i, j, m, M);
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, M[i][0]);
        }
        return max;

    }

    // this method simply returns the maximum out of all valid neighbors of that particular cell
    static int getMaxNeighbors(int i, int j, int m, int[][] mat){
        int max = 0;
        if(i != 0) {
            if(max < mat[i-1][j+1]){
                max = mat[i-1][j+1];
            }
        }
        if(max < mat[i][j+1]){
            max = mat[i][j+1];
        }
        if(i != m-1){
            if(max < mat[i+1][j+1]){
                max = mat[i+1][j+1];
            }
        }
        return max;
    }
}
