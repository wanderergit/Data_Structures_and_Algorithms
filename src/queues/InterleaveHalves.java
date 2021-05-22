package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveHalves {
    /*
        The problem is to interleave the first half of the queue with the second.
        [1, 2, 3, 4, 5, 6, 7, 8] -> [1, 5, 2, 6, 3, 7, 4, 8]
        Should be done in Linear time and space.
     */
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println("The initial configuration is -> " + q.toString());
        Queue<Integer> res = interleaveQueue(q);
        System.out.println("The final configuration is -> " + q.toString());
    }

    public static Queue<Integer> interleaveQueue(Queue<Integer> q){
        // we have to use a stack as extra space to store the last half elements
        int n = q.size();
        Stack<Integer> st = new Stack<>();

        // pushing the first half elements to the stack
        for(int i=0; i<n/2; i++){
            st.push(q.remove());
        }

        // enqueing the stack elements in the reverse order to the back of the queue
        while(!st.isEmpty()){
            q.add(st.pop());
        }

        // pushing the last half elements, which are now at the front, to the back fo the queue
        for(int i=0; i<n/2; i++){
            int a = q.remove();
            q.add(a);
        }

        // add the the reversed first half elements onto the stack, so that they come out in the initial order
        for(int i=0; i<n/2; i++){
            st.push(q.remove());
        }

        // now we pop the last half elements and interleave them with the first half
        while(!st.isEmpty()){
            int a = q.remove();
            q.add(st.pop());
            q.add(a);
        }

        return q;
    }
}
