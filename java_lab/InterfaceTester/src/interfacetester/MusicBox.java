/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacetester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class MusicBox implements SimpleQueue{
    private ArrayList<String> box;
    public MusicBox(){
        box = new ArrayList<>();
    }
    
    @Override
    public void enqueue(Object o){
        String txt = (String)o;
        box.add(txt);
        System.out.println(o.toString() + " is added in queue");
    }
    
    @Override
    public void dequeue(){
        System.out.println("Now playing " + box.get(0));
        box.remove(0);
    }
    
}
