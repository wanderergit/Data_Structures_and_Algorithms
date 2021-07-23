package Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        //     if(freq.get(nums[i]) > n/2){
        //         return nums[i];
        //     }
        // }
        // return -1;

        int candidate = getCandidate(nums);
        return getMajEle(candidate, nums);
    }

    public int getCandidate(int[] nums){
        int majIndex = 0;
        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[majIndex]){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                majIndex = i;
                count = 1;
            }
        }
        return nums[majIndex];
    }

    public int getMajEle(int candidate, int[] nums){
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(candidate == nums[i]){
                count++;
                if(count > nums.length/2){
                    return candidate;
                }
            }
        }
        return -1;
    }
}
