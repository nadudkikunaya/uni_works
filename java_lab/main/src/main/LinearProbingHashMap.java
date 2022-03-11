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
public class LinearProbingHashMap implements Map{


    private static class Entry {
        Object key, value;
        Entry(Object k, Object v) {  
            key = k; value = v;   
        }
        
        @Override
        public String toString(){
            String str = "";
            str += key + ": " + value + ",\n";
            return str;
        }
    }
    private Entry[] table;
    private int size;
    
    public LinearProbingHashMap(int m) { 
        table = new Entry[m]; 
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean containsKey(Object key) { return table[indexOf(key)] != null; }
    
    private int indexOf(Object key) {
        int h = h(key);
        for(int j=0; j<table.length; j++){
            if (table[h] == null) return h;
            if (table[h].key.equals(key)) return h;
            h = (h + 1) % table.length;
        }
        throw new AssertionError("No space!");   
    }
    
    private int h(Object key) { return (key.hashCode() & 0x7FFFFFFF) % table.length; }
    
    @Override
    public Object get(Object key) {
        Entry e = table[indexOf(key)];
        return e == null ? null : e.value;
    }

    @Override
    public Object put(Object key, Object value) {
        Object oldValue= null;
        int i= indexOf(key);
        if (table[i] == null) {
            table[i] = new Entry(key, value);
            ++size;
            if (size > table.length/2) rehash();
        } else {
            oldValue = table[i].value;
            table[i].value = value;
        }
        return oldValue;
    }

    @Override
    public void remove(Object key) {
        int i = indexOf(key);
        if (table[i] != null) {
            table[i] = null;
            --size;
        }
        i = (i+1)%table.length;
        while(table[i]!=null) {
            Entry e = table[i];
            table[i] = null;
            table[indexOf(e.key)] = e;
            i=(i+1)%table.length;
        }
    }
    
    private void rehash() {
        Entry[] oldT = table;
        table = new Entry[2 * table.length];
        for (int i= 0; i < oldT.length; i++) {
            if (oldT[i] != null)
                table[indexOf(oldT[i].key)] = oldT[i];
        }
    }
    
    public String toString(){
        String str = "{\n";
        for(int i = 0 ; i < table.length ; i++)
            if(table[i] != null)
                str += "\t" + table[i].toString();
        str += "}\n";
        return str;
    }
    
}
