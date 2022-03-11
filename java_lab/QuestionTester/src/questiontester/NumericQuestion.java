/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontester;

import java.text.DecimalFormat;

/**
 *
 * @author INatZ
 */
public class NumericQuestion extends Question {
    DecimalFormat df2 = new DecimalFormat("0.000");
    NumericQuestion(String q){
        super(q);
    }
    
    @Override
    public boolean checkAnswer(String response){
        //System.out.println(df2.format(Math.abs(Double.parseDouble(response) - Double.parseDouble(this.getAnswer()))));
        String check = df2.format(Math.abs(Double.parseDouble(response) - Double.parseDouble(this.getAnswer())));
        return  Double.parseDouble(check) <= 0.01 ;
    }
    
}
