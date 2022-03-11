public class ArrayCollection implements Collection{

    private Object[] elementData;
    private int size;

    public ArrayCollection(int c){
        elementData = new Object[c];
        size = 0;
    }

    @Override
    public void add(Object e) {
        if(e == null) throw new IllegalArgumentException();
        ensureCapacity(size + 1);
        elementData[size++] = e;
        
    }

    public void ensureCapacity(int capacity){
        if(capacity > elementData.length){
            int s = Math.max(capacity, elementData.length*2);
            Object[] arr = new Object[s];
            for(int i = 0 ; i < size ; i++){
                arr[i] = elementData[i];
            }
            elementData = arr;
        }
    }

    @Override
    public void remove(Object e) {
        int i = indexOf(e);
        if(i != -1){
            elementData[i] = elementData[size--];
            elementData[size] = null;
        }
        
    }

    @Override
    public boolean isEmpty() { return size == 0; }
    
    @Override
    public int size() { return size; }

    @Override
    public boolean contains(Object e) { return indexOf(e) != -1; }

    private int indexOf(Object e){
        for(int i = 0 ; i < size ; i++){
            if(elementData[i].equals(e)) return i;
        }
        return -1;
    }

    public Object[] toArray(){
        Object[] a = new Object[size];
        for(int i = 0 ; i < size ; i++){
            a[i] = elementData[i];
        }
        return a;
    }
    
}
