package linkedlists;

public class RevDLL {
    public static class DLLNode{
        int data;
        DLLNode next, prev;
        DLLNode(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static DLLNode reverseDLL(DLLNode  head)
    {
        DLLNode prv = null;
        DLLNode curr = head;
        DLLNode nxt = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prv;
            curr.prev = nxt;
            prv = curr;
            curr = nxt;
        }
        return prv;
    }
}
