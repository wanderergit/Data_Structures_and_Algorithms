package Arrays;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    // ONLY CHECK FROM ELEMENTS WHICH ARE AT START OF SUBSEQUENCE
    static int findLongestConseqSubseq(int arr[], int N)
    {
        // a[] = {2,6,1,9,4,5,3}
        HashSet<Integer> set = new HashSet<>();
        for(int item : arr){
            set.add(item);
        }
        int maxCount = Integer.MIN_VALUE;
        for(int item : arr){
            // if one number less is not present then current is start of consecutive sequence
            if(!set.contains(item-1)){
                int temp = item;
                int count = 0;
                while(set.contains(temp)){
                    temp++;
                    count++;
                }
                if(maxCount < count)
                    maxCount = count;
            }
        }
        return maxCount;
    }
}
