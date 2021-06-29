package BinarySearch;

public class FindInSortedRotatedArray {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l=0, h=nums.length-1;
        while(l<=h){
            int m=(l+h)/2;
            // if found return index
            if(nums[m]==target)
                return m;
            // left sorted portion
            // check if nums at mid >= nums at low, in that case we know we are in the left sorted portion
            if(nums[l] <= nums[m]){
                // check if target is greater than nums at mid, in that case check the portion to the right of mid
                if(target > nums[m])
                    l = m+1;
                // if target <= nums at mid, we should also check if target is < nums at lower
                else{
                    // if target < nums at lower, we should check the right of mid portion
                    if(target < nums[l])
                        l = m+1;
                    // else we should check the portion left of mid
                    else
                        h = m-1;
                }
            } else {
                // right sorted portion
                // if target is lesser than nums at mid, we will check the portion to the left of mid
                if(target < nums[m])
                    h = m-1;
                // if the target is greater or equal than nums at mid, we have to compare target with nums at high
                else{
                    // if target > nums at hight we will check the left of mid
                    if(target > nums[h])
                        h = m-1;
                    // else we check the right of mid
                    else
                        l = m+1;
                }
            }
        }
        return -1;
    }
}
