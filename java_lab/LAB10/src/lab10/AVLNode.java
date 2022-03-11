/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

/**
 *
 * @author INatZ
 */
public class AVLNode extends BTNode{
    private int left_h, right_h, weight;
    
    public AVLNode(Object obj, BTNode l, BTNode r, int lh, int rh, int w){
        super(obj,l,r);
        left_h = lh;
        right_h = rh;
        weight = w;
    }
    
    public int getLH(){ return left_h; }
    public int getRH(){ return right_h; }
    public int getW() { return weight; }
    
    public void setLH(int l){ left_h = l; }
    public void setRH(int r){ right_h = r; }
    public void setW(int w){ weight = w; }
    
}
