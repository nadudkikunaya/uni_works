
package exam2;

public class TestAVLTree {


    public static void main(String[] args) {
        AVLTree a = new AVLTree();
        Object[] input = {4,8,7,5,6,10,2,3,9};
        for(int i = 0 ; i < input.length ; i++)
            a.addAVL(input[i]);
        
        a.printTree();
        a.remove(8);
        a.printTree();
        
    }
    
}
