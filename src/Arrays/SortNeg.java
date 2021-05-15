package Arrays;

import static Arrays.DutchNationalFlag.swap;

public class SortNeg {
    public static void main(String[] args) {
        int[] arr = {5, 6, 0, -1, -2, 76, -11, -13};
        int[] res = sortNeg(arr, arr.length);

        for(int i : res) System.out.print(i+" ");
    }
    public static int[] sortNeg(int[] arr, int n){
        int l = 0, h = n-1;
        while(l<=h){
            if(arr[l] >= 0 && arr[h]< 0) swap(l, h, arr);
            else if(arr[l] < 0) l++;
            else if(arr[h] >= 0) h--;
        }
        return arr;
    }
}
