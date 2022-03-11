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
public interface Map2D {
   public int size();  // return จำนวของค่าทั้งหมดที่เก็บใน hash table (ดูจากคีย์ 2 ตัวคู่กัน)
   public boolean isEmpty();
   public boolean containsKey(Object key);
   public boolean containsKey(Object key1, Object key2);
   public LinearProbingHashMap get(Object key);  // return Map ที่มีคีย์เป็นค่าเดียว
   public Object get(Object key1, Object key2);
   public Object put(Object key1, Object key2, Object value);
   public void remove(Object key);  // ลบค่าที่คู่กับคีย์ (key, x) เมื่อ x เป็นค่าอะไรก็ได้
   public void remove(Object key1, Object key2); 
   public String toString();  
} 
