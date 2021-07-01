package linkedlists;

public class IsCirculate {
    boolean isCircular(Node head)
    {
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            if(temp == head){
                return true;
            }
        }
        return false;
    }
}
