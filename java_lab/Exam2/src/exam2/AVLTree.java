
package exam2;


public class AVLTree extends BinarySearchTree {
    public AVLTree(){
        super();
    }
    public AVLNode singleRightRotate(AVLNode start, AVLNode p){
        start.setLeft(p.getRight());
        p.setRight(start);
        updateW(start);
        updateW(p);
        start = p;
        return start;
    }
    
    public AVLNode singleLeftRotate(AVLNode start, AVLNode p){
        start.setRight(p.getLeft());
        p.setLeft(start);
        updateW(start);
        updateW(p);
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
        updateW(start);
        updateW(p);
        updateW(q);
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
        updateW(start);
        updateW(p);
        updateW(q);
        start = q;
        return start;
    }
    
    
    
    public void updateW(AVLNode rt){
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
    }
    
    public AVLNode Rotate(AVLNode start, AVLNode p, ArrayStack st){
        updateW(start);
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
            updateW(start);
            
            //update all parent node
            p = start;
            while(!st.isEmpty()){
                start = (AVLNode)st.pop();
                start = this.Rotate(start,p,st);
                p = start;
            }
        }
        
    }
    
    public void remove(Object rt){
        if(!this.contains(rt)){
            System.out.println("Doesn't contain this element " + rt);
            return;
        }
        BTNode startNode = getNode(rt);
        Object e = findSubMaxNode(startNode);
        AVLNode start, pre, cur;
        start = (AVLNode) root;
        ArrayStack s = new ArrayStack(10);
        pre = start;
        boolean d = false;
        while((start != null) && (!d)){
            s.push(start);
            if (start.getData() == e)
                d = true;
            else if((Integer) start.getData() > (Integer) e){
                pre = start;
                start = (AVLNode) start.getLeft();
            }
            else{
                pre = start;
                start = (AVLNode) start.getRight();
            }
        }   
        if(start == null) return;
        if ((start.getLeft() == null) && (start.getRight() == null))
            if(start == root)
            root = null;
            else
                if(pre.getLeft() == start)
                    pre.setLeft(null);
                else
                    pre.setRight(null);
        else if ((start.getLeft() != null) && (start.getRight() != null)){
            pre = start;
            cur = (AVLNode) start.getLeft();
            s.push(cur);
            while (cur.getRight() != null){
                pre = cur;
                s.push(cur);
                cur = (AVLNode) cur.getRight();
            }
            start.setData(cur.getData());
            if (pre == start)
                pre.setLeft(cur.getLeft());
            else
                pre.setRight(cur.getLeft());
        }
            else
                if(start.getLeft() != null)
                    if(start == root)
                        root = start.getLeft();
                    else
                        if(pre.getLeft() == start)
                            pre.setLeft(start.getLeft());
                        else
                            pre.setRight(start.getLeft());
                else
                    if(start == root)
                        root = start.getRight();
                else
                    if(pre.getRight() == start)
                        pre.setRight(start.getRight());
                    else
                        pre.setLeft(start.getRight());
            size --;
            s.pop();
            AVLNode p;
            while (!s.isEmpty()){
                start = (AVLNode) s.pop();
                updateW((AVLNode) start);
                if (Math.abs(start.getW()) > 1){
                    if (start.getLH() < start.getRH())
                        p = (AVLNode) start.getRight();
                    else
                        p = (AVLNode) start.getLeft();
                    Rotate(start,p,s);
                }       
            }    
    }
   
   
    
}
