package Arrays;

import java.util.HashMap;
import java.util.Arrays;

public class SortAnArrayAccordingToAnother {
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[N];
        int i = 0;
        for(int e : A1) map.put(e, map.getOrDefault(e, 0) + 1);
        for(int e : A2){
            if(map.containsKey(e)){
                for(int j=0; j<map.get(e); j++){
                    res[i++] = e;
                }
                map.remove(e);
            }
        }
        Arrays.sort(A1);
        for(int e : A1){
            if(map.containsKey(e)){
                res[i++] = e;
            }
        }
        return res;
    }
}
