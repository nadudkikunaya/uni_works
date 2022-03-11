
package lab7;


public class BinarySearchTree {
    private BTNode root;
    
    public BinarySearchTree(){
        root = null;

    }
    
    public int nnodes(){ 
        if(root == null) return 0;
        return totalChildNode(root); 
    }
    
    public int totalChildNode(BTNode p){
        if(p.getLeft() == null && p.getRight() == null)
            return 1;
        
        int left = 0, right = 0;
        if(p.getLeft() != null)
            left = totalChildNode(p.getLeft());
        if(p.getRight() != null)
            right = totalChildNode(p.getRight());
        
        return left + right + 1;
    }
    
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
        }
        else{
            while(start != null){
                pre = start;
                int data = (Integer) start.getData();
                if(data == value){
                    //System.out.println("Object: " + e + " has existed in the tree.");
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
        }
    }
    
    public void remove(Object element){
        int e = (Integer)element;
        BTNode c = root, p = c;
        while(!c.getData().equals(element)){
            p = c;
            int data = (Integer)c.getData();
            if(e < data) c = c.getLeft();
            else if(e > data) c = c.getRight();
            if(c == null){
                System.out.println("The element >> " + element + " << is not exist to be removed.");
                return;
            }
        }
//        System.out.println("p :" + p.getData() );
//        System.out.println("c :" + c.getData() );

        if(root.getData().equals(element) && root.getLeft() == null && root.getRight() == null){
            root = null;
        }
        else if(root.getData().equals(element) && root.getLeft() != null && root.getRight() == null){
            root = root.getLeft();
        }
        else if(root.getData().equals(element) && root.getLeft() == null && root.getRight() != null){
            root = root.getRight();
        }
        else if(c.getData().equals(element) && c.getLeft() == null && c.getRight() == null){ 
            if(p.getLeft() != null && p.getLeft().equals(c)) p.setLeft(null);
            else p.setRight(null);
        }
        else if(c.getData().equals(element) && c.getLeft() != null && c.getRight() == null){
            if(p.getLeft() != null && p.getLeft().equals(c)) p.setLeft(c.getLeft());
            else p.setRight(c.getLeft());
        }
        else if(c.getData().equals(element) && c.getLeft() == null && c.getRight() != null){
            if(p.getLeft() != null && p.getLeft().equals(c)) p.setLeft(c.getRight());
            else p.setRight(c.getRight());
        }
        else{
            BTNode pre2 = c;
            BTNode cur = pre2.getLeft();
                
            while(cur.getRight() != null){
                pre2 = cur;
                cur = cur.getRight();
            }
//            System.out.println("cur: " + cur.getData());
//            System.out.println("pre2: " + pre2.getData());
            int x = (Integer)cur.getData();
            this.remove(cur.getData());
            c.setData(x);

        }

    }
    
    public Object getMax(){
        BTNode start = root;
        if(start == null) return null;
        while(start.getRight() != null){ start = start.getRight(); }
        return start.getData();
    }
    
    public void printTree(){
        BTNode r = root;
        if(root == null){
            System.out.println("Tree is empty.");
            return;
        }
        System.out.println("inOrder");
        inOrder(r);
        System.out.println();
    }
    
    
    private void inOrder(BTNode r){
        if(r != null){
            inOrder(r.getLeft());
            System.out.println(r.getData() + "\t");
            inOrder(r.getRight());
        }
    }
    
    
}
