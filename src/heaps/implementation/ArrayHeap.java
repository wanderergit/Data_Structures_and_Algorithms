package heaps.implementation;

public class ArrayHeap {

    private int[] arr;
    int capacity;
    int size;

    public ArrayHeap() {
        this.arr = new int[10];
        this.capacity = 10;
        this.size = 0;
    }

    public ArrayHeap(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int val){
        if(size == capacity){
            System.out.println("Limit reached.");
        } else {
            arr[size++] = val;
            bubbleUp(size-1);
        }
    }

    private void bubbleUp(int index){
        if(index == 0 || arr[(index-1)/2] > arr[index])
            return;
        swap(index, (index-1)/2);
        bubbleUp((index-1)/2);
    }

    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int remove(){
        int temp = -1;
        if(size == 0){
            System.out.println("No elements in heap");
        } else {
            temp = arr[0];
            arr[0] = arr[size-1];
            arr[size-1] = Integer.MIN_VALUE;
            size--;
            bubbleDown(0);
        }
        return temp;
    }

    private void bubbleDown(int index){
        if(index > Math.floor((double)size/2))
            return;
        int maxChildIdx = (arr[2*index + 1] >= arr[2*index + 2]) ? 2*index + 1 : 2*index + 2;
        if(arr[maxChildIdx] > arr[index]){
            swap(maxChildIdx, index);
            bubbleDown(maxChildIdx);
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(4);

        while(!heap.isEmpty()){
            System.out.print(heap.remove()+" ");
        }
    }

}
