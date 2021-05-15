package Arrays;

import static Arrays.Reverse.reverse;

public class CyclicallyRotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        rotate(arr, -2);
        for(int i : arr) System.out.print(i+" ");
    }
    public static void rotate(int[] arr, int places){
        places = places % arr.length;
        if(places < 0) places = 8+places;
        reverse(arr, 0, places-1);
        reverse(arr, places, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }
}
