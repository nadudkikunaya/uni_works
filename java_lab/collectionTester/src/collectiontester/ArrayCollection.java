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
public class ArrayCollection implements Collection {
    private Object[] elementData;
    private int size;
    
    public ArrayCollection() {
        elementData = new Object[2];
        size = 0;
    }
    
    @Override
    public void add(Object e) {
    if (e==null) throw new IllegalArgumentException();
    ensureCapacity(size+1);   // allocate space if needed 
    elementData[size++] = e;
    }
    
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr= new Object[s];
            for (int i=0; i<size; i++) 
                arr[i]=elementData[i];
            elementData= arr;
        }
    }
    
    @Override
    public void remove(Object e) {
        int i = indexOf(e); //find the position of e
        if (i != -1) {     
        // e is in the object
        elementData[i] = elementData[--size]; // replace e
        elementData[size] = null;}
    }
    
    @Override
    public boolean equals(Object x) {
        Object e;
        if (x instanceof ArrayCollection) {
            //x is ArrayCollection// copy x to x1
            ArrayCollection x1 = new ArrayCollection();
            for (int i=0; i<((ArrayCollection) x).size; i++)
                x1.add(((ArrayCollection) x).elementData[i]);
            for (int i=0; i<size; i++) {
                e = elementData[i]; 
                if (!(x1.indexOf(e)==-1)){
                    x1.remove(e);          
                }
                else 
                    return false;
            }
            return x1.isEmpty();
        }
        else {
            return false;
        }
    }
    
    private int indexOf(Object e) {  
    // return position of e
    for (int i=0; i<size; i++) {
        if (elementData[i].equals(e)) {
            // found e
            return i;     // return the position of e
        }
    }
    return -1;          // when e is not found, return -1
    }
    
    @Override
    public boolean contains(Object e) { return indexOf(e) != -1; }
    @Override
    public int size() { return size; }
    @Override
    public boolean isEmpty() { return size==0; }
    
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i=0; i<size; i++) {
            a[i]= elementData[i];}
        return a;
       }
}
