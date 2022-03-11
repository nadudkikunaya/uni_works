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
public class HashMap2D implements Map2D {
    
    private static class MapEntry {
        Object key;
        LinearProbingHashMap map;
        
        MapEntry(Object k, LinearProbingHashMap m){
            key = k;
            map = m;
        }
        
        public String toString(){
            String str = "";
            str += key + ":" + map.toString();
            return str;
        }
    }
    
    private MapEntry[] table;
    private int size;
    
    public HashMap2D(int n){
        table = new MapEntry[n];
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean containsKey(Object key) { 
        return table[indexOf(key)] != null; 
    }

    @Override
    public boolean containsKey(Object key1, Object key2) {
        if(this.containsKey(key1))
            return table[indexOf(key1)].map.containsKey(key2);
        return false;
    }
    
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
    public LinearProbingHashMap get(Object key) {
        return table[indexOf(key)].map;
    }

    @Override
    public Object get(Object key1, Object key2) {
        return table[indexOf(key1)].map.get(key2);
    }

    @Override
    public Object put(Object key1, Object key2, Object value) {
        Object oldValue= null;
        int i = indexOf(key1);
        if (table[i] == null) {
            table[i] = new MapEntry(key1 , new LinearProbingHashMap(3));
            table[i].map.put(key2, value);
            ++size;
            if (size > table.length/2) rehash();
        } else {
            oldValue = table[i].map.get(key2);
            if(oldValue == null){
                table[i].map.put(key2, value);
                ++size;
            }
            else
                table[i].map.put(key2, value);
        }
        return oldValue;
    }
    
    private void rehash() {
        MapEntry[] oldT = table;
        table = new MapEntry[2 * table.length];
        for (int i= 0; i < oldT.length; i++) {
            if (oldT[i] != null)
                table[indexOf(oldT[i].key)] = oldT[i];
        }
    }

    @Override
    public void remove(Object key) {
        int i= indexOf(key);
        if (table[i] != null) {
            table[i] = null;
            --size;
        }
        i = (i+1) %table.length;
        while(table[i] !=null ) {
            MapEntry e = table[i];
            table[i] = null;
            table[indexOf(e.key)] = e;
            i = (i+1) %table.length;
        }
    }

    @Override
    public void remove(Object key1, Object key2) {
        table[indexOf(key1)].map.remove(key2);
        
    }
    
    public String toString(){
        String str = "{\n";
        for(int i = 0 ; i < table.length ; i++)
            if(table[i] != null)
                str += table[i].toString();
        str += "}";
        return str;
    }
}
