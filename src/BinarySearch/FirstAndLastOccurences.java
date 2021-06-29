package BinarySearch;

import java.util.ArrayList;

public class FirstAndLastOccurences {
    ArrayList<Long> find(long arr[], int n, int x) {
        // do binary search and then go in either direction to find the other same elements
        ArrayList<Long> res = new ArrayList<>();
        boolean found = false;
        int start = 0;
        int end = 0;
        int l = 0, m = 0, h = n-1;
        while(l<=h){
            m = l-(l-h)/2;
            if(arr[m] > x)
                h = m-1;
            else if(arr[m] < x)
                l = m+1;
            else {
                start = m;
                end = m;
                found = true;
                break;
            }
        }
        if(found){
            while(start>0 && arr[start-1] == x)
                start--;
            while(end<n-1 && arr[end+1] == x)
                end++;
            res.add((long)(start));
            res.add((long)(end));
        } else {
            res.add((long)-1);
            res.add((long)-1);
        }
        return res;
    }
}
