package graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
    https://www.geeksforgeeks.org/find-whether-it-is-possible-to-finish-all-tasks-or-not-from-given-dependencies/
 */
public class PossibleToCompleteAllTasksGFG {
    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {2, 0}, {3, 0}, {3, 2}, {4 ,3}, {2, 4}};
        int n = 6;
        System.out.println(isCompletionPossible(arr, n));
    }
    public static boolean isCompletionPossible(int[][] arr, int n){
        int[] indegree = getIndegree(arr, n);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i< indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            visited[curr] = true;
            for(int i=0; i<arr.length; i++){
                if(!visited[arr[i][0]]){
                    if(arr[i][1] == curr) indegree[arr[i][0]]--;
                    if(indegree[arr[i][0]] == 0)
                        q.add(arr[i][0]);
                }
            }
        }
        if(count!=n) return false;
        return true;
    }
    public static int[] getIndegree(int[][] arr, int n){
        int[] indegree = new int[n];
        for(int i=0; i<arr.length; i++){
            indegree[arr[i][0]]++;
        }
        return indegree;
    }
}
