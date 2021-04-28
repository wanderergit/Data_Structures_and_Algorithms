package heaps.implementation;

public class SampleHeap {

    int[] heap;
    int lastIndex;

    //default constructor
    SampleHeap() {
        heap = new int[10];
        lastIndex = -1;
    }

    //parameterised constructor
    SampleHeap(int capacity) {
        heap = new int[capacity];
        lastIndex = -1;
    }

    //just looking at the topmost element in the heap
    public int peek(){
        return heap[0];
    }

    //insert is adding an element into the heap
    public void insert(int val){
        //(1) insert element into the last position
        if(lastIndex+1 < heap.length){
            lastIndex = lastIndex+1;
            heap[lastIndex] = val;

            //(2) swapping the last with the first
            swap(0, lastIndex);

            //(3) bubbling up the last element until it satisfies heap invariant
            swim(lastIndex);
        } else {
            System.out.println("heap capacity reached.");
        }
    }

    private int getParent(int index){
        if(index%2 == 0){
            return (index - 2)/2;
        }
        return (index-1)/2;
    }

    private int getLowerChild(int index){
        int leftChildIndex = 2*index+1;
        int rightChildIndex = 2*index+2;

        //we will choose the left child in case it is smaller or there is a tie.
        if(heap[leftChildIndex] <= heap[rightChildIndex]) return leftChildIndex;
        return rightChildIndex;
    }

    private void swim(int index){
        int parent = getParent(index);
        int curr = index;

        if(curr != 0 && heap[parent] > heap[curr]){
            while(curr != 0 && heap[parent] > heap[curr]) {
                swap(curr, parent);
                curr = parent;
                parent = getParent(curr);
            }
        }
    }

    private void sink(int index){


    }

    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    //polling is removing the topmost element from the heap
    public int poll(){
        //(1) swap with the last element in the heap
        swap(0, lastIndex);
        //(2) remove the last element from the heap
        int res = heap[lastIndex];
        lastIndex = lastIndex - 1;
        //(3) bubble down till heap invariant is satisfied.
        if(heap[0] > heap[1] || heap[0] > heap[2])
            sink(0);

        return res;
    }

}

class Demo {
    public static void main(String[] args) {
        SampleHeap sh = new SampleHeap();
        sh.insert(34);
        sh.insert(6);
        sh.insert(3);
        sh.insert(4);
        System.out.println(sh.peek());
    }
}