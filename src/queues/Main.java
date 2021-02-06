package queues;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johnDoe = new Employee("john", "doe", 231);
        Employee marySmith = new Employee("mary", "smith", 332);
        Employee mikeWilson = new Employee("mike", "wilson", 832);
        Employee billEnd = new Employee("bill", "end", 938);

        ArrayQueue queue = new ArrayQueue(10);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);


        queue.remove();
        queue.remove();
        queue.printQueue();

    }
}
