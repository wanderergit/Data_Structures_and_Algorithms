package linkedlists;

public class SortedIntersection {
    public static Node findIntersection(Node head1, Node head2)
    {
        Node ptr1 = head1;
        Node ptr2 = head2;

        Node temp = new Node(-1);
        Node p = temp;

        while(ptr1 != null && ptr2!=null){
            if(ptr1.val == ptr2.val){
                Node newNode = new Node(ptr1.val);
                p.next = newNode;
                p = newNode;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            } else if(ptr1.val < ptr2.val){
                ptr1 = ptr1.next;
            } else {
                ptr2 = ptr2.next;
            }
        }

        return temp.next;

    }
}
