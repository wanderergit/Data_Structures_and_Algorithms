package Arrays;

/*
    this is a very important problem, revise it's concept
 */

import java.util.LinkedList;
import java.util.Arrays;

public class mergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(arr);
        for(int[] interval : res){
            System.out.print(Arrays.toString(interval) + ", ");
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for(int[] interval : intervals){
            if(res.isEmpty() || res.getLast()[1] < interval[0]){
                res.add(interval);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
