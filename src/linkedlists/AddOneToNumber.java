package linkedlists;

public class AddOneToNumber {
    public static void main(String[] args) {
        Node n1 = new Node(9);
        Node n2 = new Node(9);
        Node n3 = new Node(9);
        Node n4 = new Node(9);
        Node n5 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node res = addOne(n1);
        Node.printList(res);
    }
    public static Node addOne(Node head){
        int carry = recurse(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static int recurse(Node head){
        // base cond
        if(head.next == null){
            if(head.val == 9){
                head.val = 0;
                return 1;
            } else {
                head.val += 1;
                return 0;
            }
        }
        int carry = recurse(head.next);
        if(carry == 1){
            if(head.val == 9){
                head.val = 0;
                return 1;
            } else {
                head.val += 1;
                return 0;
            }
        }
        return 0;
    }
}
