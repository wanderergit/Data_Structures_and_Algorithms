package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FactorialOfLargeNumber {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> arr = new ArrayList<>();

        // maintain array with elements as digits in result
        arr.add(1);
        int arrSize = 1;

        // find factorial of number and update digits in array
        for(int x=2; x<=N; x++){
            arrSize = multiply(x, arr, arrSize);
        }
        Collections.reverse(arr);
        return arr;
    }
    static int multiply(int x, ArrayList<Integer> res, int resSize){
        int carry = 0;

        for(int i=0; i<resSize; i++){
            int prod = res.get(i) * x + carry;
            res.set(i, prod%10);
            carry = prod/10;
        }

        while(carry != 0){
            res.add(carry%10);
            carry = carry/10;
            resSize++;
        }

        return resSize;
    }
}
