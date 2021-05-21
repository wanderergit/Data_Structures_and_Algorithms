package queues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        Queue<Integer> res = modifyQueue(q, 3);

        System.out.println(res.toString());

    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k){
        int temp = k;
        reverseQueue(q, temp);

        int remCount = q.size()-k;
        while(remCount-- > 0){
            int a = q.remove();
            q.add(a);
        }
        return q;
    }

    public static void reverseQueue(Queue<Integer> q, int k){
        if(k == 0){
            return;
        }
        int a = q.remove();
        k--;
        reverseQueue(q, k);
        q.add(a);
    }

}
