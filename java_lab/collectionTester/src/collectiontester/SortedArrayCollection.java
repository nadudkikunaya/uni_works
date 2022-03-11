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
public class SortedArrayCollection implements Collection {
    private Object[] elementData;
    private int size;
    
    public SortedArrayCollection() {
        elementData = new Object[2];
        size = 0;
    }
    
    @Override
    public void add(Object e) {
        //System.out.println("Add " + (Integer)e);
    if (e==null) {throw new IllegalArgumentException(); };
     ensureCapacity(size+1);
    if(this.size == 0){
        elementData[0] = e;
    }
    else if((Integer)e >=  (Integer)elementData[size-1]){
        //System.out.println("Case 2"); 
        elementData[size] = e;
    }
    else{
        //System.out.println("Case 3");
        int s = Math.max(size+1, 2*elementData.length);
        Object[] temp = new Object[s];
        int index = 0;
        boolean isValid = true;
        for(int i = 0 ; i < size ; i++){
            if((Integer)elementData[i] >= (Integer)e && isValid){
                temp[index++] = e;
                isValid = false;
            }
            temp[index++] = elementData[i];
        }
        this.elementData = temp;
    }
    size++;
    //System.out.println("Please add value which equal or more than : " + (Integer)elementData[size-1]);
    }
    
    private void ensureCapacity(int capacity) {
        //System.out.println(capacity  + "," + elementData.length);
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr= new Object[s];
            for (int i=0; i<size; i++) 
                arr[i]= elementData[i];
            elementData= arr;
            //System.out.println("up size");
        }
    }
    
    @Override
    public void remove(Object e) {
        int i = indexOf(e); //find the position of e
        if (i != -1) {     
        // e is in the object
        for(int index = i ; index < size ; index++)
            elementData[i] = elementData[++i]; // replace e
        elementData[size] = null;}
        size--;
    }
    
    @Override
    public boolean equals(Object x) {
        Object e;
        if (x instanceof ArrayCollection) {
            //x is ArrayCollection// copy x to x1
            SortedArrayCollection x1 = new SortedArrayCollection();
            for (int i=0; i<((SortedArrayCollection) x).size; i++)
                x1.add(((SortedArrayCollection) x).elementData[i]);
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
    int l = 0, r = this.size - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
  
            // Check if x is present at mid
            if (elementData[m].equals(e))
                return m;
  
            // If x greater, ignore left half
            if ((Integer) elementData[m] < (Integer)e)
                l = m + 1;
  
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
  
        // if we reach here, then element was
        // not present
        return -1;
                  // when e is not found, return -1
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
    
    public void show(){
        for(int i=0 ; i < size ; i++){
            System.out.println((Integer)elementData[i]);
        }
    }
    
}
