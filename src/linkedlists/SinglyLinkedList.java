package linkedlists;

public class SinglyLinkedList {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 12);
        Employee johnDoe = new Employee("John", "Doe", 22);
        Employee marySmith = new Employee("Mary", "Smith", 11);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();

        System.out.println(list.getSize());

    }
}
