/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

/**
 *
 * @author INatZ
 */
public class Vertex {
    private char title;
    private boolean visit;
    public Vertex(char label){
        title = label;
        visit = false;
    }
    
    public char getTitle(){ return title; }
    public boolean getVisit(){ return visit; }
    public void setVisit(boolean v){ visit = v; }
}
