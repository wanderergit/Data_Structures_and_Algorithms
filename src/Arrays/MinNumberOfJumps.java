package Arrays;

/*
    Find the minimum number of jumps to reach the end.
 */

public class MinNumberOfJumps {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Min. number of jumps : " + minJumps(arr));

    }
    public static int minJumps(int[] arr){
        int n = arr.length;
        int currEnd = 0, farthest = 0, jumps = 0;
        for(int i=0; i<n-1; i++){
            farthest = Math.max(farthest, i+arr[i]);
            if(farthest >= n-1) return 1+jumps;
            if(i == farthest) return -1;
            if(i == currEnd){
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }
}
