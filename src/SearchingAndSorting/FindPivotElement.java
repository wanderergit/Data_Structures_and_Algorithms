package SearchingAndSorting;

public class FindPivotElement {
    // suppose an initially sorted array is rotated N places to the right
    // initially -> [1, 2, 3, 4, 5, 6, 7], after rot -> [4, 5, 6, 7, 1, 2, 3]
    // find the pivot(largest) element in this rotated sorted array
    /*
        Cases: suppose we are at the left side of pivot, we want to search to the right of mid
     */

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 1, 2, 3};

        int l=0, m=0, h=arr.length-1;

        while(l<=h){
            m = (l+h)/2;
            // if mid reaches the lowerbound
            if (m == 0) {
                if (m == arr.length-1) {
                    // Only 1 element
                    System.out.println("N is " + m);
                } else if (arr[m] >= arr[m + 1]) {
                    // Pivot is the greater element
                    System.out.println("N is " + m);;
                }
            } else if (m == args.length-1) {
                // if mid reaches the upperbound
                if (arr[m] >= arr[m - 1]) {
                    // Pivot is the greater element
                    System.out.println("N is " + m);
                }
            } else {
                // if mid is between lower and upperbound
                if (arr[m - 1] < arr[m] && arr[m + 1] < arr[m]) {
                    System.out.println("The Pivot is " + arr[m]);
                    System.out.println("N is " + m);
                    break;
                } else if (arr[l] <= arr[m]) {
                    // if we are on the left side
                    l = m + 1;
                } else {
                    // if we are on the right side
                    h = m - 1;
                }
            }
        }
    }
}
