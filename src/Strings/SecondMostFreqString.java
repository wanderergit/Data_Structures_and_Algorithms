package Strings;

import java.util.HashMap;

public class SecondMostFreqString {
    public static void main(String[] args) {
        int N = 7;
        String arr[] = {"ghi", "ghi", "aaa", "ghi", "ghi", "ghi", "ghi"};
        System.out.println(secFrequent(arr, N));
    }

    public static String secFrequent(String arr[], int N)
    {
        // we can use a hashMap here

        HashMap<String, Integer> map = new HashMap<>();

        // storing the frequencies of each string

        for(int i=0; i<N; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            } else {
                int existingVal = map.get(arr[i]);
                map.put(arr[i], existingVal+1);
            }
        }



        // now traverse the array to find the second largest freq

        int largest = 0;
        int secondLargest = 0;

        for(String i : map.keySet()) {
            if(map.get(i)>largest){
                largest = map.get(i);
            }
        }

        String res = "";

        for(String i : map.keySet()) {
            if(map.get(i)>secondLargest && map.get(i) < largest){
                secondLargest = map.get(i);
                res = i;
            }
        }

        return res;

    }
}
