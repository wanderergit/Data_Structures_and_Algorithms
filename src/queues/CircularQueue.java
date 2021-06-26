package queues;

public class CircularQueue {
    private int []cq;
    private int size;
    private int front;
    private int rear;
    private int capacity;

    CircularQueue(int n){
        cq = new int[n];
        size = 0;
        front = 0;
        rear = 0;
        capacity = n;
    }

    public void enqueue(int val){
        if(front == rear && front !=0){
            System.out.println("Queue is full! Remove elements to add more.");
        } else {
            if(rear != capacity-1){
                cq[rear] = val;
                rear += 1;
            } else {
                cq[rear] = val;
                rear = 0;
            }
            System.out.println(val + " is added!");
        }
    }

}

class Demo {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
        cq.enqueue(1);
    }
}
