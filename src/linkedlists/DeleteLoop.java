package linkedlists;

public class DeleteLoop {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        System.out.println(deleteLoop(n1));
    }
    public static Node deleteLoop(Node head){
        // first we will detect loop

        return head;
    }

}
