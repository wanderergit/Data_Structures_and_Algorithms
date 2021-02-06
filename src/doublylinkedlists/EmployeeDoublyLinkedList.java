package doublylinkedlists;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;


    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        if(head == null){
            tail = node;
        } else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if(tail == null){
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public void addBefore(Employee employee1, Employee employee2){
        EmployeeNode node = new EmployeeNode(employee1);
        EmployeeNode curr = head;
        while(curr != null) {
            if(curr.getEmployee() == employee2){
                if(curr == head){
                    node.setNext(head);
                    head.setPrevious(node);
                    head = node;
                    break;
                } else {
                    node.setNext(curr);
                    curr.getPrevious().setNext(node);
                    curr.setPrevious(node);
                }
            }

        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty())
            return null;
        EmployeeNode tempNode = head;

        if(head.getNext() == null){
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        tempNode.setNext(head);
        return tempNode;
    }

    public EmployeeNode removeFromEnd(){
        if(isEmpty())
            return null;
        EmployeeNode tempNode = tail;

        if(tail.getNext() == null){
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        tempNode.setPrevious(null);
        return tempNode;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }


}
