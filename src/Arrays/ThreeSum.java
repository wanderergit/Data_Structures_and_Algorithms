package Arrays;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {

    }
    public static boolean find3Numbers(int A[], int n, int X) {

        Arrays.sort(A);
        for(int i=0; i<n; i++){
            int ptr1 = i+1;
            int ptr2 = n-1;
            while(ptr1 < ptr2){
                if(A[ptr1] + A[ptr2] == X-A[i])
                    return true;
                else if(A[ptr1] + A[ptr2] > X-A[i])
                    ptr2--;
                else
                    ptr1++;
            }
        }
        return false;
    }
}
