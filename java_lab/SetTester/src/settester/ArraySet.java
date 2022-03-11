/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settester;

/**
 *
 * @author INatZ
 */
public class ArraySet implements Set{
    private int size;
    private Object[] member;
    
    public ArraySet(){
        member = new Object[2];
        size = 0;
    }
    
    public int indexOf(Object e){
        for(int i = 0 ; i < size ; i++){
            if(member[i].equals(e))
                return i;
        }
        return -1;
    }
    
    @Override
    public boolean contains(Object e) { return indexOf(e) != -1; }
    
    
    @Override
    public void add(Object e) {
        if (e==null) {throw new IllegalArgumentException(); };
        if(!contains(e)){
            ensureCapacity(size+1);
            member[size] = e;
            size++;
        }
    }

    @Override
    public void remove(Object e) {
        int index = indexOf(e);
        if(index != -1){
            member[index] = member[--size];
            member[size] = null;    
        }
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public ArraySet union(Set s) {
        ArraySet unionSet = new ArraySet();
        if(s instanceof ArraySet){
            ArraySet set = (ArraySet)s;
            for(int i = 0 ; i < size ; i++)
                unionSet.add(member[i]);
            for(int i = 0 ; i < set.size ; i++){
                if(!unionSet.contains(set.member[i])){
                    unionSet.add(set.member[i]);
                }       
            }
        } 
        return unionSet; 
    }

    @Override
    public ArraySet intersection(Set s) {
        ArraySet intersecSet = new ArraySet();
        ArraySet set;
        if(s instanceof ArraySet){
            for(int i = 0 ; i < ((ArraySet) s).size ; i++ ){
                set = (ArraySet)s;
                if(this.contains(set.member[i]))
                    intersecSet.add(set.member[i]);
            }
        }
        return intersecSet;
    }

    @Override
    public boolean equals(Set s) {
        if(s instanceof ArraySet){
            ArraySet set = (ArraySet)s;
            int checkContains = 0;
            if(set.size == this.size){
                for(int i = 0 ; i < set.size ; i++){
                    if(this.contains(set.member[i]))
                        checkContains++;
                }
                return checkContains == this.size;
            }
         
        }
        return false;

    }
    
    private void ensureCapacity(int capacity) {
        if (capacity > member.length) {
            int s = Math.max(capacity, 2*member.length);
            Object[] arr = new Object[s];
            for (int i=0; i<size; i++) 
                arr[i] = member[i];
            member = arr;
        }
    }
    
    //public int size() { return size; }
//    public void show(){
//        for(int i = 0 ; i < size ; i++){
//            System.out.println(member[i]);
//        }
//    }
    
    @Override
    public String toString(){
        String str = "{";
        if(!this.isEmpty()){
            for(int i = 0 ; i < size-1 ; i++){
                str += member[i] + ",";
            }    
            str += member[size-1] + "}";
        }
        else
            str += "}";
        return str;
    }
    
}
