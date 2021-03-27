package stacks.implementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueues {
    public static void main(String[] args) {

        Stack obj = new Stack();
        obj.push(8);
        obj.printStack();
        obj.push(90);
        obj.printStack();
        obj.pop();
        obj.printStack();
        obj.push(56);
        obj.printStack();
        obj.push(83);
        obj.printStack();
        obj.pop();
        obj.printStack();
    }
}


class Stack {
    Queue<Integer> q1  = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    public void push(int ele){
        q1.add(ele);
    }

    public int pop() {
       while(q1.size() > 1){
           q2.add(q1.remove());
       }
       int res = q1.remove();
       Queue<Integer> temp = q1;
       q1 = q2;
       q2 = temp;
       return res;
    }

    public void printStack() {
        System.out.println(Arrays.toString(q1.toArray()));
    }
}