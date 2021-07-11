package Arrays.SlidingWindow;

public class ThreeWayPartition {
    public void threeWayPartition(int array[], int a, int b){
        // modification of dutch national flag

        int low=0, mid=0,high = array.length-1;

        while(mid <= high){
            int currMid = array[mid];
            if(currMid < a){
                swap(array, mid, low);
                low++;
                mid++;
            } else if(currMid > b){
                swap(array, mid, high);
                high--;
            } else {
                mid++;
            }
        }

    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
