/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphismdemo;

/**
 *
 * @author INatZ
 */
public class PolymorphismDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        m(new GraduateStudent());m(new Student());m(new Person());m(new Object());
    }
    public static void m(Object x) {System.out.println(x.toString());}
    
}
