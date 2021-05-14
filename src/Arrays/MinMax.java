package Arrays;

public class MinMax {

    static class Pair{
        int min;
        int max;
        Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        /*
            Find the minimum and the maximum element in the array
         */

        int[] arr = {-55, 6, 76, 100, -2, -13, 0};
        int n = arr.length;

        Pair result = getMinMax(arr, n, 0, n-1);

        System.out.println("Min : " + result.min + ", Max : " + result.max);
    }

    public static Pair getMinMax(int[] arr, int n, int low, int high){
        if(low == high) return new Pair(arr[low], arr[low]);
        else if(low + 1 == high) return new Pair(Math.min(arr[low], arr[high]), Math.max(arr[low], arr[high]));

        Pair left = getMinMax(arr, n, low, (low+high)/2);
        Pair right = getMinMax(arr, n,(low+high)/2, high);
        return new Pair(Math.min(left.min, right.min), Math.max(left.max, right.max));
    }
}
