package linkedlists;

public class SeparateEvenOdd {
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

        Node res = divide(n1);
        Node.printList(res);

    }
    public static Node divide(Node head){

        Node tempEven = new Node(-1);
        Node tempOdd = new Node(-1);

        Node p1 = tempEven;
        Node p2 = tempOdd;

        Node p = head;
        while(p != null){
            if(p.val%2 == 0){
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }

        // connect even and odd parts
        p2.next = null;
        p1.next = tempOdd.next;
        return tempEven.next;

    }
}
