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
public class StudentTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student me = new Student("Siri Mala",6334567823L);
        System.out.println(me.getName()+" "+me.getID()+" "+me.getScore()+" "+me.getGrade());
    }
    
}
