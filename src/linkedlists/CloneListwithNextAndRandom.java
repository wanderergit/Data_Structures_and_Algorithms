package linkedlists;

import java.util.HashMap;

public class CloneListwithNextAndRandom {
    static class NodeWithRandom{
        int data;
        NodeWithRandom next, arb;
        NodeWithRandom(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        NodeWithRandom n1 = new NodeWithRandom(9);
        NodeWithRandom n2 = new NodeWithRandom(9);
        NodeWithRandom n3 = new NodeWithRandom(9);
        NodeWithRandom n4 = new NodeWithRandom(9);
        NodeWithRandom n5 = new NodeWithRandom(9);

        n1.next = n2;
        n1.arb = n3;
        // and so on..

        copyList(n1);

    }
    public static NodeWithRandom copyList(NodeWithRandom head) {

        HashMap<NodeWithRandom, NodeWithRandom> map = new HashMap<>();

        if(head == null)
            return head;
        NodeWithRandom temp = head;

        while(temp!=null){
            map.put(temp, new NodeWithRandom(temp.data));
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            NodeWithRandom cloneNode = map.get(temp);
            cloneNode.next = map.getOrDefault(temp.next, null);
            cloneNode.arb = map.getOrDefault(temp.arb, null);
            temp = temp.next;
        }

        return map.get(head);

    }
}
