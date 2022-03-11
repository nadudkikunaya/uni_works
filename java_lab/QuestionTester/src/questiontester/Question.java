/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontester;

/**
 *
 * @author INatZ
 */
public class Question {
    private String question;
    private String answer;
    
    public Question(){
        question = "";
        answer = "";
    }
    
    public Question(String q){
        question = q;
    }
    
    public Question(String q, String a){
        question = q;
        answer = a;
    }
    
    public void setText(String q){
        question = q;
    }
    
    public void setAnswer(String a){
        answer = a;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getAnswer(){
        return answer;
    }
    
    public boolean checkAnswer(String response){
        return response.equals(answer);
    }
    
    public void display(){
        System.out.println(this.getQuestion());
    }
}
