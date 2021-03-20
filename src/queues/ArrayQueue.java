package queues;


public class ArrayQueue{

    private int[] q;
    private int front, back;
    private int capacity;

    public ArrayQueue() {
        q = new int[10];
        capacity = 10;
    }

    public ArrayQueue(int cap){
        q = new int[cap];
        capacity = cap;
    }

    public void enqueue(int ele){
        if(back == capacity){
            int[] newArr = new int[2*capacity];
            System.arraycopy(q, 0, newArr, 0, capacity);
            q = newArr;
            newArr = null;
        }
        q[back] = ele;
        back = back + 1;
    }

    public int dequeue() {
        int res = q[front];
        front++;
        return res;
    }

    public int size(){
        return back-front;
    }

    public int capacity(){
        return capacity;
    }

    public int front(){
        return q[front];
    }

    public int back(){
        return q[back];
    }

    public void printQueue(){
        System.out.println("Queue : ");
        System.out.print("Front -> ");
        for(int i=front; i<back; i++){
            System.out.print(q[i] + " -> ");
        }
        System.out.println("null");
    }

}