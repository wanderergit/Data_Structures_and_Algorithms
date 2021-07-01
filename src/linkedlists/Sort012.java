package linkedlists;
/*
    Sort a ll of 0s, 1s, 2s
 */
public class Sort012 {
    public static void main(String[] args) {

    }
    static Node segregate(Node head)
    {
        if(head == null || head.next == null) return head;
        int[] freq = new int[3];
        Node temp = head;
        freq[temp.val]++;
        while(temp != null && temp.next != null){
            temp = temp.next;
            freq[temp.val]++;
        }

        temp = head;
        while(freq[0]-->0){
            temp.val = 0;
            temp = temp.next;
        }
        while(freq[1]-->0){
            temp.val = 1;
            temp = temp.next;
        }
        while(freq[2]-->0){
            temp.val = 2;
            temp = temp.next;
        }
        return head;
    }
}
