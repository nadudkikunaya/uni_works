/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecteditemtester;

/**
 *
 * @author INatZ
 */
public class SelectedItem {
    private String productNo;
    private int quantity;
    
    public SelectedItem(String p, int q){
        productNo = p;
        quantity = q;
    }
    
    public boolean equals(SelectedItem e){
        return this.productNo.equals(e.productNo) && this.quantity == e.quantity;
    }
}
