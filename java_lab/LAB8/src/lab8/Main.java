
package lab8;
public class Main {
    public static void main(String[] args) {
        Heap h = new Heap();
        int[] arr = {0,20,9,32,6,15,25,50,5,8,13,18};
        int numNode = arr.length-1;
        System.out.print("Input Array: ");
        h.printHeap(arr, numNode);
        h.buildHeap(arr, numNode);
        System.out.print("Heap Array: ");
        h.printHeap(arr, numNode);
    }
    
}
