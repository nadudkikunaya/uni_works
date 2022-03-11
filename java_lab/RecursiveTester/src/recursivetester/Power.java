/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivetester;

/**
 *
 * @author INatZ
 */
public class Power {
    private int n,base;
    private int ans;
    public Power(int b, int num){
        n = num;
        base = b;
        ans = recurPower(base,n);
    }
    
    public int recurPower(int base, int num){
        if(num == 1){
            return base;
        }
        else
            return base*recurPower(base,num-1);
    }
    
    public String toString(){
        return Integer.toString(ans);
    }
}
