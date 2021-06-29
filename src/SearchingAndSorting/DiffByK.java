package SearchingAndSorting;
/*
    Searching in an array where adjacent differ by at most k
    GFG : https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/
    A step array is an array of integers where each element has a difference of at most k with its neighbor.
    Given a key x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
 */
public class DiffByK {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 6}, k = 1, x = 6;
        // return 2 which is the index of first match found
        // naive approach is to traverse this array linearly
        // optimisation is to jump diff/k times
        // where diff is the difference of current element and target

        int i=0;
        while(i<arr.length) {
            if (arr[i] == x) {
                System.out.println(i);
                break;
            }
            int diff = Math.max(1, Math.abs(x - arr[i]));
            i += diff;
        }
    }
}
