package Arrays;

public class MaxProductSubarray {
    long maxProduct(int[] arr, int n) {

        long minVal = arr[0];
        long maxVal = arr[0];

        long maxProduct = arr[0];

        for(int i=1; i<n; i++){
            // if negative element, swap max and minValues;
            if(arr[i] < 0){
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            maxProduct = Math.max(maxVal, maxProduct);
        }
        return maxProduct;

    }
}
