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
public class SetTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArraySet set = new ArraySet();
        ArraySet set2 = new ArraySet();
        
        /* equals */
//        set.add(1); set.add(2); set.add(3);
//        set.add("TEST"); set.add(3); 
//        
//        set2.add("TEST"); set2.add(3); set2.add(2);
//        set2.add(1);
//        
//        System.out.println(set.equals(set2));
        

        /* union and intersection */
//        System.out.println(set.isEmpty());
        
        set.add(1); 
        set.add(2); set.add(3);
        set.add("TEST"); set.add(3); 
        
        set2.add("TEST"); set2.add(3); set2.add(4);
        set2.add(5); set2.remove(5);
        
        ArraySet ans = set.union(set2);
        System.out.println(ans.toString());
    }
    
}
