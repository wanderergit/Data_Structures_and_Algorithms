package queues;

public class Main {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(20);
        queue.enqueue(68);
        queue.enqueue(64);
        queue.enqueue(61);
        queue.enqueue(66);
        queue.enqueue(62);
        queue.enqueue(53);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        System.out.println("Size : " + queue.size());
    }
}
