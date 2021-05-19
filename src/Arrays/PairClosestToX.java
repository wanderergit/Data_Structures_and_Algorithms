//package Arrays;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//public class PairClosestToX {
//    public static void main(String[] args) {
//        int arr[] = {10, 22, 28, 29, 30, 40}, x = 54;
//        System.out.println(Arrays.toString(solve(arr, x)));
//    }
//    public static int[] solve(int[] arr, int x){
//        int minDist = Integer.MAX_VALUE;
//        int[] res = new int[2];
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0; i<arr.length; i++){
//            for(int ele : set){
//                if(Math.abs(ele-arr[i]) < minDist){
//                    minDist = Math.abs(x-(ele+arr[i]));
//                    res[0] = ele;
//                    res[1] = arr[i];
//                }
//            }
//            set.add(arr[i]);
//        }
//        return res;
//    }
//}
