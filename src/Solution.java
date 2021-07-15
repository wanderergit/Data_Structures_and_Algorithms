public class Solution {
    public static void main(String[] args) {

        System.out.println(solution(14));
    }

    public static int sumOfDigits(int N){
        int sum = 0;
        for(int i=1; i<=N; i++)
            sum += i;
        return sum;
    }

    public static long findSmallest(int num){
        return ((num%9 + 1) * ((long)Math.pow(10, num/9)) - 1);
    }

    public static int solution(int N) {
        // N = 14
        // Ans = 19

        // 1+4 = 5, 1+9 = 10

        // find the sum of digits of the input number
        int sum = sumOfDigits(N);
        System.out.println(sum);

        // find the smallest number greater than 'N' whose sum is twice as much as 'sum'
        return (int)findSmallest(2*sum);

    }

//    public static boolean isGuard(char curr){
//        return (curr == 'v' || curr == '^' || curr == '<' || curr == '>');
//    }
//
//    public static void markInvalids(int x, int y, String[] B){
//        char curr = B[x].charAt(y);
//
//        if(curr == '>'){
//            graph[x][y] = '>';
//            int i = x;
//            int j = y+1;
//            char[] chars = B[i].toCharArray();
//            while(j < B[0].length() && chars[j] != 'X' && !isGuard(chars[j])){
//                graph[i][j] = 'X';
//                j++;
//            }
//        } else if (curr == '<'){
//            graph[x][y] = '<';
//            int i = x;
//            int j = y-1;
//            char[] chars = B[i].toCharArray();
//            while(j >= 0 && chars[j] != 'X' && !isGuard(chars[j])){
//                graph[i][j] = 'X';
//                j--;
//            }
//        } else if(curr == '^'){
//            graph[x][y] = '^';
//            int i=x-1;
//            int j=y;
//            while(i >= 0){
//                char[] chars = B[i].toCharArray();
//                if(chars[j] == 'X' || isGuard(chars[j]))
//                    break;
//                graph[i][j] = 'X';
//                i--;
//            }
//        } else if(curr == 'v'){
//            graph[x][y] = 'v';
//            int i=x+1;
//            int j=y;
//            while(i < B.length){
//                char[] chars = B[i].toCharArray();
//                if(chars[j] == 'X' || isGuard(chars[j]))
//                    break;
//                graph[i][j] = 'X';
//                i++;
//            }
//        }
//    }
//
//    static int R;
//    static int C;
//    static int moveCount;
//    static int nodesLeftInLayer;
//    static int nodesInNextLayer;
//
//    static boolean reachedEnd;
//    static boolean[][] visited;
//
//    static int dr[] = {-1, 1, 0, 0};
//    static int dc[] = {0, 0, 1, -1};
//
//    static Queue<Integer> rq;
//    static Queue<Integer> cq;
//
//    static char[][] graph;
//
//    public static void exploreNeighbors(int r, int c, String[] B){
//        for(int i=0; i<4; i++){
//            int rr = r + dr[i];
//            int cc = c + dc[i];
//
//            if(rr < 0 || cc < 0 || rr >= R || cc >= C) continue;
//            if(visited[rr][cc] || graph[rr][cc] == 'X' || isGuard(B[rr].charAt(cc))) continue;
//
//            rq.add(rr);
//            cq.add(cc);
//            visited[rr][cc] = true;
//            nodesInNextLayer++;
//        }
//    }
//
//    public static boolean solution(String[] B) {
//
//        // the idea is to preprocess the graph to mark all invalid cells
//        // then do a BFS traversal to see if the bottom right cell is reached or not
//        R = B.length;
//        C = B[0].length();
//        graph = new char[R][C];
//        moveCount = 0;
//        nodesLeftInLayer = 1;
//        nodesLeftInLayer = 0;
//        reachedEnd = false;
//        visited = new boolean[R+1][C+1];
//
//        rq = new LinkedList<>();
//        cq = new LinkedList<>();
//
//        int sr = 0;
//        int sc = 0;
//
//        for(int i=0; i<B.length; i++){
//            for(int j=0; j<B[0].length(); j++){
//                char curr = B[i].charAt(j);
//                if(isGuard(curr)){
//                    markInvalids(i, j, B);
//                } else if (curr == 'A'){
//                    graph[i][j] = 'A';
//                    sr = i;
//                    sc = j;
//                } else if (curr == 'X'){
//                    graph[i][j] = 'X';
//                }
//            }
//        }
//
//
//        printGraph(graph);
//        // perform BFS
//
//        rq.add(sr);
//        cq.add(sc);
//
//        visited[sr][sc] = true;
//
//        while(!rq.isEmpty()){
//            int r = rq.remove();
//            int c = cq.remove();
//            if(r == R-1 && c == C-1){
//                reachedEnd = true;
//            }
//
//            exploreNeighbors(r, c, B);
//
//            nodesLeftInLayer--;
//            if(nodesLeftInLayer == 0){
//                nodesLeftInLayer = nodesInNextLayer;
//                nodesInNextLayer = 0;
//            }
//
//        }
//        return reachedEnd;
//    }
//
//    public static void printGraph(char[][] graph){
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(" " + (char)graph[i][j]);
//            }
//            System.out.println();
//        }
//    }

}
