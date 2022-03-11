
package lab10;


public class BinarySearchTree {
    protected BTNode root;
    protected int size;
    
    public BinarySearchTree(){
        root = null;
        size = 0;
    }
    
    public int size(){ return size; }
    public boolean isEmpty(){ return root == null; }
    
    public boolean contains(Object e){
        BTNode start = root;
        int value = (Integer) e;
        while(start != null){
            int data = (Integer)start.getData();
            if(data == value) return true;
            else{
                if(value < data) start = start.getLeft();
                else start = start.getRight();
            }
        }
        return false;
    }
   
    
    public void add(Object e){
        if(e == null) return;
        BTNode start = root, pre = null;
        BTNode tmp = new BTNode(e, null, null);
        int value = (Integer) e;
        
        if(root == null){
            root = tmp;
            size++;
        }
        else{
            while(start != null){
                pre = start;
                int data = (Integer) start.getData();
                if(data == value){
                    System.out.println("Object: " + e + " has existed in the tree.");
                    start = null;
                    return;
                }
                else{
                    if(value < data) start = start.getLeft();
                    else start = start.getRight();
                }
            }
            int curNode = (Integer) pre.getData();
            if(value < curNode) pre.setLeft(tmp);
            else if(value > curNode) pre.setRight(tmp);
            size++;
        }
    }
    
    public Object getMin(){
        BTNode start = root;
        if(start == null) return null;
        while(start.getLeft() != null){ start = start.getLeft(); }
        return start.getData();
    }
    
    public Object getMax(){
        BTNode start = root;
        if(start == null) return null;
        while(start.getRight() != null){ start = start.getRight(); }
        return start.getData();
    }
    
    public void printTree(){
        BTNode r = root;
        if(isEmpty()) System.out.println("Tree is empty.");
        System.out.println("Preorder");
        preOrder(r);
        System.out.println();
    }
    
    public void preOrder(BTNode r){
        if(r != null){
            System.out.println(r.getData() + "\t");
            preOrder(r.getLeft());
            preOrder(r.getRight());
        }
    }
    
    public void inOrder(BTNode r){
        if(r != null){
            inOrder(r.getLeft());
            System.out.println(r.getData() + "\t");
            inOrder(r.getRight());
        }
    }
    
    public void postOrder(BTNode r){
        if(r != null){
            postOrder(r.getLeft());
            postOrder(r.getRight());
            System.out.println(r.getData() + "\t");
        }
    }
    
}
