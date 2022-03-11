
package lab9;


public class AVLTree extends BinarySearchTree {
    public AVLTree(){
        super();
    }
    public AVLNode singleRightRotate(AVLNode start, AVLNode p){
        start.setLeft(p.getRight());
        p.setRight(start);
        update(start);
        update(p);
        start = p;
        return start;
    }
    
    public AVLNode singleLeftRotate(AVLNode start, AVLNode p){
        start.setRight(p.getLeft());
        p.setLeft(start);
        update(start);
        update(p);
        start = p;
        return start;
        
    }
    
    public AVLNode doubleRightRotate(AVLNode start, AVLNode p){
        AVLNode q;
        q = (AVLNode)p.getRight();
        p.setRight(q.getLeft());
        start.setLeft(q.getRight());
        q.setRight(start);
        q.setLeft(p);
        update(start);
        update(p);
        update(q);
        start = q;
        return start;        
    }
    
    public AVLNode doubleLeftRotate(AVLNode start, AVLNode p){
        AVLNode q;
        q = (AVLNode)p.getLeft();
        p.setLeft(q.getRight());
        start.setRight(q.getLeft());
        q.setLeft(start);
        q.setRight(p);
        update(start);
        update(p);
        update(q);
        start = q;
        return start;
    }
    
    
    
    public void update(AVLNode rt){
        AVLNode cLeft, cRight;
        cLeft = (AVLNode)rt.getLeft();
        cRight = (AVLNode)rt.getRight();
        //update lh,rh
        if(cLeft != null)
            rt.setLH(Math.max(cLeft.getLH(), cLeft.getRH()) + 1);
        else
            rt.setLH(0);
        
        if(cRight != null)
            rt.setRH(Math.max(cRight.getLH(),cRight.getRH()) + 1);
        else
            rt.setRH(0);
        //update w
        
        rt.setW(rt.getLH() - rt.getRH());
//        System.out.print("Data: " + rt.getData() + " ");
//        System.out.println(rt.getLH() + "/"+ rt.getRH());
//        System.out.println();
    }
    
    public AVLNode rotate(AVLNode start, AVLNode p, ArrayStack st){
        update(start);
        if(Math.abs(start.getW()) > 1){
            if(start.getW() < 0) //leftRotate
            {
                if(p.getW() <= 0) // - and - then singleRotate
                    start = singleLeftRotate(start,p);
                else // - and + then doubleRotate
                    start = doubleLeftRotate(start,p);
                    
            }
            else //rightRotate
            {
                if(p.getW() >= 0) // + and + then singleRotate
                    start = singleRightRotate(start,p);
                else // + and - then doubleRotate
                    start = doubleRightRotate(start,p);
            }
            
            if(!st.isEmpty()){
                AVLNode k = (AVLNode)st.peek();
                if((Integer)start.getData() < (Integer)k.getData())
                    k.setLeft(start);
                else if((Integer)start.getData() > (Integer)k.getData())
                    k.setRight(start);
            }
            else{
                root = start;
            }
                
        }
        return start;
    }
    
    public void addAVL(Object e){
        AVLNode start, newNode, p;
        newNode = new AVLNode(e,null,null,0,0,0);
        ArrayStack st = new ArrayStack(10);
        
        if(root == null)
            root = newNode;
        else{
            //find parent node
            start = (AVLNode) root;
            while(start != null){
                st.push(start);
                if((Integer)e < (Integer)start.getData())
                    start = (AVLNode)start.getLeft();
                else if((Integer)e > (Integer)start.getData())
                    start = (AVLNode)start.getRight();
            }
            //add newNode
            start = (AVLNode)st.pop();
            if((Integer)e < (Integer)start.getData())
                start.setLeft(newNode);
            else if((Integer)e > (Integer)start.getData())
                start.setRight(newNode);
            update(start);
            
            //update all parent node
            p = start;
            while(!st.isEmpty()){
                start = (AVLNode)st.pop();
                start = this.rotate(start,p,st);
                p = start;
            }
        }
        
    }
    
    
}
