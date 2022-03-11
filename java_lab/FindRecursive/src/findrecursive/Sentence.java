/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findrecursive;

/**
 *
 * @author INatZ
 */
public class Sentence {
    private String s;
    public Sentence (String s) {
        this.s = s;
    }
    
    public boolean find(String sub){
        return findSubString(sub,s,0,sub.length());
    }
    
    private boolean findSubString(String sub, String str,int start, int end){

        //System.out.println(str.substring(start, end));
        if(end > str.length())
            return false;
        else if(sub.equals(str.substring(start, end)))
            return true;
        else
            return findSubString(sub,str,start+1,end+1);
            
        
    }
}
