package BinarySearch;

public class FindRepeatedElement {
    public static void main(String[] args) {

    }
    static int findRepeatingElement(int arr[], int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        // if mid element is not at it's right position, then we have to search to the left (smaller elements)
        if (arr[mid] != mid + 1) {
            if (mid > 0 && arr[mid] == arr[mid-1])
                return mid;
            // If mid element is not at its position that means
            // the repeated element is in left
            return  findRepeatingElement(arr, low, mid-1);
        }
        // If mid is at proper position then repeated one is in
        // right.
        return findRepeatingElement(arr, mid+1, high);
    }
}
