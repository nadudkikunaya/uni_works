/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitextractortester;

/**
 *
 * @author INatZ
 */
public class DigitExtractor {
    private int num = 0;
    private int numExtracted = 0;
    DigitExtractor(int num){
        this.num = num;
        this.numExtracted = num;
    }
    public int nextDigit(){
        int lastDigit = this.numExtracted % 10;
        this.numExtracted = this.numExtracted / 10;
        return lastDigit;
    }
}
