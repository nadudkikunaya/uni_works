/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphadjlsttester;

/**
 *
 * @author INatZ
 */
public class SinglyLinkedList implements List{
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next) {
        this.element = e;
        this.next = next;
        }
    }
    
    private LinkedNode header = new LinkedNode(null, null);
    private int size = 0;
    
    public SinglyLinkedList(){
    }
    
    private void assertInRange(int i){
        if(i < -1 && i >= size){
            throw new IndexOutOfBoundsException();
        }
    }
    
    private void assertNotNull(Object e){
        if(e.equals(null))
            throw new IllegalArgumentException();
    }
    
    private LinkedNode nodeAt(int i){
        assertInRange(i);
        LinkedNode node = header;
        for(int index = -1 ; index < i ; index++)
            node = node.next;
        return node;
    }

    @Override
    public void add(Object element) {
        this.add(0, element);
    }

    @Override
    public void remove(Object element) {
        if(!this.contains(element)) throw new IllegalArgumentException("This element is not exist"); 
        assertNotNull(element);
        LinkedNode node = header;
        while(node.next != null && !node.next.element.equals(element)){
            node = node.next;
        }
        
        if(node.next != null){
            node.next = node.next.next;
            --size;
        }
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean contains(Object element) {
        for(int i = 0 ; i < size ; i++)
            if(nodeAt(i).element.equals(element))
                return true;
        return false;
    }
    
    public boolean equals(SinglyLinkedList x){
        if(x.size() != this.size )
            return false;
        for(int i = 0 ; i < x.size() ; i++){
            if(!this.contains(x.nodeAt(i).element))
                return false;
        }
        return true;
    }

    @Override
    public int size() { return size; }

    @Override
    public void add(int i, Object e) {
        assertInRange(i);
        assertNotNull(e);
        LinkedNode node = nodeAt(i-1);
        node.next = new LinkedNode(e,node.next);
        ++size;
    }

    @Override
    public void removeAt(int i) {
        assertInRange(i);
        LinkedNode node = nodeAt(i-1);
        node.next = node.next.next;
        --size;
        
    }

    @Override
    public Object get(int i) { return nodeAt(i).element; }

    @Override
    public void set(int i, Object e) {
        assertNotNull(e);
        assertInRange(i);
        LinkedNode p = nodeAt(i);
        p.element = e;
    }
    
    public String toString(){
        String str = "";
        int startAt = 0;
        LinkedNode node = nodeAt(startAt);
        while(startAt < size){
            str += node.element + " ";
            node = node.next;
            startAt++;
            
        }

        return str;
    }
    

}
