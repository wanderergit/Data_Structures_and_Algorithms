package stacks.implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class FromDeque {

    static class Stack{

        Deque<Integer> deque;
        int capacity;
        int top;

        Stack(int n){
            deque = new ArrayDeque<>();
            capacity = n;
            top = 0;
        }

        public void push(int n){
            if(top == capacity){
                System.out.println("Capacity Reached!");
            } else {
                deque.addFirst(n);
                top++;
            }
        }

        public int peek(){
            return deque.peekFirst();
        }

        public int pop(){
            if(deque.isEmpty()){
                System.out.println("Stack is empty!");
                return Integer.MIN_VALUE;
            }
            top--;
            return deque.removeFirst();
        }

        public void display(){
            System.out.print("top -> ");
            System.out.print(deque.toString());
            System.out.println(" <- base");
        }

    }

    public static void main(String[] args) {
        /*
            This is a program to demonstrate the implementation of stacks using deque
            Deques are double ended queues. Insertion and deletion can occur at either end.
         */

        Stack st = new Stack(5);
        st.pop();

    }
}
