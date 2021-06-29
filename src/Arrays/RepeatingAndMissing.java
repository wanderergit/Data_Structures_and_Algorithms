package Arrays;

import java.util.HashSet;

public class RepeatingAndMissing {
    public static void main(String[] args) {

    }
    int[] findTwoElement(int arr[], int n) {
        // one solution is make hashSet and first find the repeating element in the
        // first iteration and then find the missing element in the second
        // but this would give a O(N) space complexity
        HashSet<Integer> set = new HashSet<>();

        int[] res = new int[2];
        for(int element : arr){
            if(!set.contains(element))
                set.add(element);
            else
                res[0] = element;
        }
        // now that hashSet all elements except missing
        for(int i=1; i<=n; i++) {
            if (!set.contains(i)) {
                res[1] = i;
            }
        }
        return res;
    }
}
