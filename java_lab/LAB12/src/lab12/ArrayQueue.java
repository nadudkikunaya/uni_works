package lab12;

import java.util.NoSuchElementException;

public class ArrayQueue implements Queue{
    private Object[] elementData;
    private int size;
    private int front;
    public ArrayQueue(int cap){
        elementData = new Object[cap];
        size = front = 0;
    }

    public boolean isEmpty(){ return size == 0; }
    public int size(){ return size; }

    public void enqueue(Object e){
        if(size == elementData.length){
            Object[] a = new Object[elementData.length*2];
            int j = front;
            for(int i = 0 ; i < size; i++){
                a[i] = elementData[j];
                j =(j+1)%elementData.length;
            }
            elementData = a;
            front = 0;
        }
        int b = (front + size) % elementData.length;
        elementData[b] = e;
        size++;
    }

    public Object peek(){
        if(isEmpty()) throw new NoSuchElementException();
        return elementData[front];
    }

    public Object dequeue(){
        Object e = peek();
        elementData[front] = null;
        front = (front + 1) % elementData.length;
        size--;
        return e;
    }
    
}
