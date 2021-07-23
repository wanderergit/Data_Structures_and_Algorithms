package Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        // we know that the range of answers will lie between 1 and nums.length [1 .... nums.length]
        // this range will fit into the given array exactly

        // for example : arr =  [3,4,-1,1], range fits exactly in this array of size four [1, 2, 3, 4]
        // so we will use the original array to store all the positive integers found while iterating it

        // [3, 4, -1, 1]
        // for 3 'i', set arr[3-1]=arr[2] to 3, set arr[i] to 0, and store the value at arr[2] = -1 in another variable
        // iterate through for all values of i and skip if value is out of range or value == i+1 (which denotes the number is in it's right place)

        int n = nums.length;
        for(int i=0; i<n; i++){
            int x = nums[i];
            nums[i] = 0;
            while(true){
                if(x < 1 || x > n || x == nums[x-1]) break;
                int y = nums[x-1];
                nums[x-1] = x;
                x = y;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] == 0) return i+1;
        }
        return n+1;
    }
}
