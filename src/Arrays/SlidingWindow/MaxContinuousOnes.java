package Arrays.SlidingWindow;

import java.util.ArrayList;

public class MaxContinuousOnes {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(0);
                add(1);
                add(1);
                add(0);
                add(0);
                add(1);
                add(1);
                add(1);
            }
        };

        int B = 1;

        ArrayList<Integer> res = maxone(A, B);
        System.out.println(res.toString());
    }
    public static ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {

        int currZeros = 0;

        int l=0;
        int r=0;

        int minMaxIndex[] = new int[2];
        minMaxIndex[0] = l;
        minMaxIndex[1] = r;
        ArrayList<Integer> res = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int currMax = 0;
        while(r<A.size()){
            if(A.get(r) == 1){
                currMax+=1;
                if(currMax > max){
                    max = currMax;
                    minMaxIndex[0] = l;
                    minMaxIndex[1] = r;
                }
            } else {
                if(currZeros < B){
                    currZeros++;
                    currMax++;
                    if(currMax > max){
                        minMaxIndex[0] = l;
                        minMaxIndex[1] = r;
                        max = currMax;
                    }
                } else {
                    while(A.get(l) != 0 && l!=r){
                        currMax--;
                        l++;
                    }
                    l++;
                }
            }
            r++;
        }

        for(int i=minMaxIndex[0]; i<=minMaxIndex[1]; i++){
            res.add(i);
        }

        return res;

    }
}
