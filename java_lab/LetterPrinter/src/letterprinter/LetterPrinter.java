/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterprinter;

/**
 *
 * @author INatZ
 */
public class LetterPrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Letter myLetter = new Letter("Jade","Clarissa");
        myLetter.addLine("We must find Simon quickly.");
        myLetter.addLine("He might be in danger.");
        System.out.println("Dear " + myLetter.sender + ":");
        System.out.println(myLetter.getText());
        System.out.println("Sincerely,\n");
        System.out.println(myLetter.receiver);
    }
    
}
