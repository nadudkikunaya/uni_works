public class ArrayList implements List {
    private Object[] elementData;
    private int size;
    public ArrayList(int cap){
        elementData = new Object[cap];
        size = 0;
    }

    public int size(){ return size; }

    public boolean isEmpty(){ return size == 0; }

    public boolean contains(Object e){ return indexOf(e) != -1; }

    public void add(Object e){
        add(size,e);
    }

    public void add(int index, Object e){
        ensureCapacity(size+1);
        for(int i = size ; i > index ; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        size++;
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

    public void remove(Object e){
        int i = indexOf(e);
        if(i >= 0)
            remove(i);
    }

    public void remove(int index){
        for(int i = index+1 ; i < size ; i++){
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
    }

    public int indexOf(Object e){
        for(int i = 0; i < size; i++){
            if(elementData[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public Object get(int index){ return elementData[index]; }
    public void set(int index, Object e){ elementData[index] = e;}
}
