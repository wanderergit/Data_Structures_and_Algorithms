package stacks.implementation;

public class ArrayStack {
    private int[] st;
    private int top, capacity;

    public ArrayStack() {
        st = new int[10];
        capacity = 10;
    }

    public ArrayStack(int cap){
        st = new int[cap];
        capacity = cap;
    }

    public void push(int ele){
        if(this.top == this.capacity){
            int[] newArray = new int[2*capacity];
            System.arraycopy(st, 0, newArray, 0, st.length);
            st = newArray;
            newArray = null;
        }
        st[top] = ele;
        top = top+1;
    }

    public int pop(){
        int res = st[top-1];
        top = top-1;
        return res;
    }

    public int top(){
        return st[top-1];
    }

    public int size(){
        return top;
    }

    public int capacity(){
        return capacity;
    }

    public void printStack(){
        System.out.println("Stack : ");
        for(int i=top-1; i>=0; i--){
            System.out.println(st[i]);
        }
    }
}
