/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenttester;

/**
 *
 * @author INatZ
 */
public class Student {
    private String name;
    private long sid;
    private int score;
    private String grade;
    
    public Student(String name, long sid)
    {
        this.name = name;
        this.sid = sid;
    }
    
    public Student(String name, long sid, int score)
    {
        this.name = name;
        this.sid = sid;
        this.score = score;
        this.grade = calGrade(score);
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setID(long sid){
        this.sid = sid;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getName(){
        return this.name;
    }
    public long getID(){
        return this.sid;
    }
    public int getScore(){
        return this.score;
    }
    public String getGrade(){
        return this.grade;
    }
    public String calGrade(int score){
        if(score >= 100 || score < 0)
            return "X";
        else if(score >= 80)
            return "A";
        else if(score >= 75)
            return "B+";
        else if(score >= 70)
            return "B";
        else if(score >= 65)
            return "C+";
        else if(score >= 60)
            return "C";
        else if(score >= 55)
            return "D+";
        else if(score >= 50)
            return "D";
        else
            return "F";  
    }
    
}
