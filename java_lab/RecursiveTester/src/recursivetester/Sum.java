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
public class Sum {
    private int n;
    private int ans;
    public Sum(int num){
        n = num;
        ans = recurSum(n);
    }
    
    public int recurSum(int num){
        if(num == 1){
            return 1;
        }
        else
            return num + recurSum(num-1);
    }
    
    public String toString(){
        return Integer.toString(ans);
    }
}
