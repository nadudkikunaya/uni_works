/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluationtester;

/**
 *
 * @author INatZ
 */
public class Subject implements Evaluation{
    private String subjectName;
    private int[] score;
    
    public Subject(String n, int[] sc){
        this.subjectName = n;
        this.score = sc;
    }
    
    @Override
    public double evaluate(){
        int cnt = 0;
        double total = 0;
        for(int sc : score){
            total += sc;
            cnt++;
        }
        return total / cnt;
    }
    
    @Override
    public char grade(double avg){
        if(avg >= 70){
            return 'P';
        }
        else{
            return 'F';
        }
    }
    
    @Override
    public String toString(){
        return this.subjectName;
    }
}
