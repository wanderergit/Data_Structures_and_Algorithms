package DynamicProgramming.problems.Kadanes;

public class KadaneDP {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = 8;
        System.out.println(solve(arr, n));
        // prints 7
    }
    public static int solve(int[] arr, int n){

        int mx = arr[0], curr = arr[0];

        for(int i=1; i<n; i++){
            curr = Math.max(curr + arr[i], arr[i]);
            mx = Math.max(curr, mx);
        }
        return mx;
    }
}
