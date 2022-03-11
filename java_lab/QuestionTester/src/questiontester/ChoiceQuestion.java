/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class ChoiceQuestion extends Question{
    private ArrayList<String> choices = new ArrayList<>();
    public ChoiceQuestion(String q){
        super(q);
    }
    
    public void addChoice(String choice, boolean correct){
        choices.add(choice);
        if(correct){
            int ans = choices.size();
            this.setAnswer(Integer.toString(ans));
        }
    }
    
    @Override
    public void display(){
        System.out.println(this.getQuestion());
        int num = 1;
        for(String ans : choices){
            System.out.println(num + ": " + ans);
            num++;
        }
        
    }
    
    @Override
    public boolean checkAnswer(String response){
        return response.equals(this.getAnswer());
    }
}
