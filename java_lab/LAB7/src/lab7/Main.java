
package lab7;

public class Main {


    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        Object[] arr = {9,2,12,1,5,10,15};
        for(int i = 0 ; i < arr.length ; i++)
           b.add(arr[i]);
        System.out.println("nnodes: " + b.nnodes());
        System.out.println("max: " + b.getMax());
        System.out.println("contains [12]: " + b.contains(12));
        System.out.println("contains [20]: " + b.contains(20));
        b.remove(5);
        b.printTree();

    }
    
}
