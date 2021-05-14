package Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 9, 0, -6};

        reverse(arr, arr.length);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void reverse(int[] arr, int n){
        int temp = 0, high = n-1, low = 0;
        while(high > low){
            temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            high--;
            low++;
        }
    }
}
