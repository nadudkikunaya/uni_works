package lab10;

public class BTNode {
    private Object data;
    private BTNode left;
    private BTNode right;
    
    public BTNode(Object obj, BTNode l, BTNode r){
        data = obj;
        left = l;
        right = r;
    }
    
    public void setLeft(BTNode l){ left = l; }
    public void setRight(BTNode r){ right = r; }
    public void setData(Object obj){ data = obj; }
    
    public BTNode getLeft(){ return left; }
    public BTNode getRight(){ return right; }
    public Object getData(){ return data; }
    
}
