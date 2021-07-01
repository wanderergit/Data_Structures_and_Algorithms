package linkedlists;

import java.util.HashSet;

public class RemoveDups {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node res = removeDuplicatesSorted(n1);
        Node.printList(res);

        n1.next = n3;
        n3.next = n2;
        n2.next = n5;
        n5.next = n4;
        n4.next = null;

        Node res2 = removeDuplicatesUnsorted(n1);
        Node.printList(res2);

    }
    public static Node removeDuplicatesSorted(Node head){
        Node curr = head;
        while(curr!=null){
            Node nxt = curr.next;
            if(nxt != null && curr.val == nxt.val){
                curr.next = nxt.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
    public static Node removeDuplicatesUnsorted(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        while(curr!=null) {
            Node nxt = curr.next;
            if (nxt == null) {
                break;
            } else if (set.contains(nxt.val)) {
                curr.next = nxt.next;
            } else if (!set.contains(nxt.val)) {
                set.add(nxt.val);
                curr = curr.next;
            }
        }
        return head;
    }
}
