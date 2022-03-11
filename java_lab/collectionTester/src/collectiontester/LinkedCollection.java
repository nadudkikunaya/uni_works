/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectiontester;

/**
 *
 * @author INatZ
 */
public class LinkedCollection implements Collection {
   private static class LinkedNode{
       private Object element;
       private LinkedNode next;
       LinkedNode(Object e, LinkedNode n) {
           element = e;
           next = n;
       }
   }
   
   private int size;
   private LinkedNode header;
   
   public LinkedCollection() {
       size = 0;
       header = new LinkedNode(null, null); 
   }
   
    public int size() {return size;}
    
    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void add(Object e) {
        if (e==null) throw new IllegalArgumentException();
        header.next = new LinkedNode(e, header.next);
        size++;
    }

    @Override
    public void remove(Object e) {
        LinkedNode node = header;      
        // we look at node.next
        while (node.next!=null && !node.next.element.equals(e))
            node = node.next;           // look at the next node
        if (node.next!=null) {    // found the node to be removed
            node.next = node.next.next;size--;
        }
    }

    @Override
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while (node!=null && !node.element.equals(e)) {
            node = node.next;
        }
        return node!=null;
    }
    
    public void merge(Object a){
        if(a instanceof LinkedCollection){
            LinkedNode node = ((LinkedCollection) a).header;
            int i = 0;
            while(i < ((LinkedCollection)a).size){
                node = node.next;
                i++;
            }
            node.next = this.header.next;
            this.header.next = ((LinkedCollection) a).header.next;
            
        }
        this.size += ((LinkedCollection) a).size;
    }
    
    public void addAfter(Object a, Object b){
         LinkedNode node = header;   
         LinkedNode insertNode;
        // we look at node.next
        while (node.next!=null && !node.next.element.equals(a)){
            node = node.next;           // look at the next node
        }
        System.out.println("Found " + node.next.element + "," + node.next.next);
        if(node.next != null){
            if(node.next.next == null){
                insertNode = new LinkedNode(b,null);
                System.out.println("newNode : " + b + "," + null);
                
            }
            else{
                insertNode = new LinkedNode(b, node.next.next);
            }
            node.next.next = insertNode;
            size++;
//            LinkedNode insertNode = new LinkedNode(b, node.next.next);
//            node.next = insertNode;
//            size++;
        }
        
    }
    
    public void show(){
        LinkedNode node = header.next;
        int i = 0;
        while(i < size){
            System.out.println(node.element + "," + node.next);
            node = node.next;
            i++;
        }
    }

   
}