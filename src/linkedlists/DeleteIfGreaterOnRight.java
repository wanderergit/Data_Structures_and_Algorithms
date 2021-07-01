package linkedlists;

public class DeleteIfGreaterOnRight {
    public static void main(String[] args) {

    }
    public static Node compute(Node head)
    {
        if(head.next==null)
            return head;
        Node temp=compute(head.next);
        if(temp.val > head.val)
            return temp;
        else
            head.next=temp;
        return head;
    }
}
