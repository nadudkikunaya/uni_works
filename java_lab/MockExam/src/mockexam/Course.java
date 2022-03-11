/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockexam;

/**
 *
 * @author INatZ
 */
public class Course {
    private String cName;
    private String cID;
    private double credit;
    public Course(String name, String id, double cr){
        this.cName = name;
        this.cID = id;
        this.credit = cr;
    }
    public String getName(){
        return this.cName;
    }
    public String getID(){
        return this.cID;
    }
    public double getCredit(){
        return this.credit;
    }
}
