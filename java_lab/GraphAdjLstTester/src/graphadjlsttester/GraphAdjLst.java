/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphadjlsttester;

/**
 *
 * @author INatZ
 */
public class GraphAdjLst {
    private int v;
    private SinglyLinkedList[] adjacent;
    
    public GraphAdjLst(int v, Object[][] edges){
        this.v = v;
        adjacent = new SinglyLinkedList[v];
        for(int i = 0 ; i < v ; i++){
            SinglyLinkedList linkList = new SinglyLinkedList();
            for (Object[] edge : edges) {
                if (edge[0].equals(i)) {
                    if(!linkList.contains(edge[1])) linkList.add(edge[1]);
                }
            }
            adjacent[i] = linkList;
        }
    }
    
    public boolean equals(GraphAdjLst x){
        if(x.getV() != this.v)
            return false;
        for(int i = 0 ; i < this.v ; i++){
            if(!this.adjacent[i].equals(x.getAdjacentAt(i)))
                return false;
        }
        return true;
    }
    
    public int degree(int x) { return adjacent[x].size(); }
    public boolean connect(int x, int y) { return adjacent[x].contains(y); }
  
    public int getV(){ return v; }
    public SinglyLinkedList getAdjacentAt(int index) { 
        if(index >= v && index < 0)
            throw new IndexOutOfBoundsException();
        return adjacent[index]; 
    }
    
    @Override
    public String toString(){
        String str = "v : " + v + "\n";
        for(int i = 0 ; i < adjacent.length ; i++)
            str += "node " + i + " : " + adjacent[i].toString() + "\n";
        return str; 
    }
}
