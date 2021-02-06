package queues;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
        if(size() == queue.length-1){
            //need to resize the backing array
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back] = employee;
        if(back < queue.length-1){
            back ++;
        } else {
            back = 0;
        }
    }

    public Employee remove(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if(isEmpty()){
            front = 0;
            back = 0;
        }
        return employee;
    }

    public Employee peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public boolean isEmpty(){
        if(size() == 0)
            return true;
        return false;
    }

    public int size(){
        return back-front;
    }

    public void printQueue(){
        for(int i=front; i<back; i++){
            System.out.println(queue[i]);
        }
    }
}
