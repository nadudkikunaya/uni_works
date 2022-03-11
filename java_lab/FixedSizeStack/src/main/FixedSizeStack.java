/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author INatZ
 */
public class FixedSizeStack implements Stack {
    private Object[] elementData;
    private int size;    
    private int limitSize;
    
    public FixedSizeStack(int limit){
        limitSize = limit;
        size = 0;
        elementData = new Object[limit];
    }
    
    @Override
    public boolean isEmpty(){ return size==0; }
    @Override
    public int size(){ return size; }
    
    private void isExceed(){
        if(size+1 > limitSize){
            Object[] x = new Object[limitSize];
            for(int i = 1 ; i < size ; i++)
                x[i-1] = elementData[i];
            elementData = x;
            size--;
        }
    }
    
    @Override
    public void push(Object e){  
        isExceed();
        elementData[size++] = e;
//        for(int i = 0 ; i < size ; i++)
//            System.out.print(elementData[i] + " ");
//        System.out.println("");
    }
    
    @Override
    public Object peek(){
        if (isEmpty()) throw new IllegalStateException();
        return elementData[size-1];
    }
    
    @Override
    public Object pop(){
        Object e = peek();   
        elementData[--size] = null;
        return e;
    }
}
