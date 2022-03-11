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
public class M {
    private int iter;
    public M(int i){
        iter = i;
    }
    
    public double recurM(int i){
        if(i == 1){
            return (double)1/(i+1);
        }
        else
            return ((double)i/(i+1)) + recurM(i-1);
    }
    @Override
    public String toString(){
        return Double.toString(recurM(iter));
    }
}
