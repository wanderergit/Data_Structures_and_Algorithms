package linkedlists;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingInAStream {
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("aabc"));
    }
    public static String firstNonRepeating(String A)
    {
        Queue<Character> q = new LinkedList<>();
        // to hold the frequency of each character
        int arr[] = new int[26];

        char[] chars = A.toCharArray();
        StringBuilder res = new StringBuilder("");

        // for each character in stream
        for(int i=0; i<chars.length; i++){
            // add the character to the queue
            q.add(chars[i]);
            // increase it's frequency
            arr[chars[i] - 'a']++;
            while(!q.isEmpty()){
                // if the frequency of the first character in the queue is > 1, remove it
                if(arr[q.peek() - 'a'] > 1){
                    q.remove();
                } else break;
            }
            if(q.isEmpty()){
                res.append("#");
            } else {
                res.append(q.peek());
            }
        }
        return res.toString();
    }
}
