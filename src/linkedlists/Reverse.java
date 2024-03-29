package linkedlists;

public class Reverse {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node.printList(n1);
//        Node revHead = reverseLL(n1);
//        Node.printList(revHead);

//        Node revHead2 = reverseLLIterative(n1);
//        Node.printList(revHead2);

        Node rev = reverseInGroupsK(n1, 3);
        Node.printList(rev);

    }

    public static Node reverseLL(Node head){
        if(head == null || head.next == null)
            return head;

        Node rest = reverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    public static Node reverseLLIterative(Node head){
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
        Node nxt = null;

        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    public static Node reverseInGroupsK(Node head, int k){
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
        Node nxt = null;

        int count = 0;
        while(count < k && curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count++;
        }

        if(nxt != null)
            head.next = reverseInGroupsK(nxt, k);

        return prev;
    }

}
