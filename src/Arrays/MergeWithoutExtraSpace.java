package Arrays;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {0,2, 5, 7};
        int[] arr2 = {1, 3, 6, 8, 9};
        merge2(arr1, arr2, arr1.length, arr2.length);
        for(int i : arr1) System.out.print(i + " ");
        for(int i : arr2) System.out.print(i + " ");
    }
    /*
        this is the longer method, which gives TLE
     */
    public static void merge(int arr1[], int arr2[], int n, int m) {
        for(int i=0; i<n; i++){
            if(arr1[i] > arr2[0]){
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                int j = 0;
                while(j<m-1 && arr2[j] > arr2[j+1]){
                    temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                    j++;
                }
            }
        }
    }
    /*
        this is the faster solution, swap first and then sort ((n+m)log(n+m))
     */
    public static void merge2(int arr1[], int arr2[], int n, int m) {
        int i = n-1; int j = 0;
        while(i >= 0 && j < m){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            else break;
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
