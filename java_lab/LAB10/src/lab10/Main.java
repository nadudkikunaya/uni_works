
package lab10;


public class Main {

    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        Object[] arr = {5,7,10,12,13,15,25,28};
        for(int i = 0 ; i < arr.length ; i++)
            t.addAVL(arr[i]);
        t.removeAVL(12); t.removeAVL(15);
        t.printTree();        
    }
    
}
