/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacetester;

/**
 *
 * @author INatZ
 */
public class InterfaceTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MusicBox m = new MusicBox();
        m.enqueue("Ao jao oei");
        m.enqueue("ter nor ter");
        m.enqueue("piang sob ta");
        m.enqueue("buppesanniwas");
        m.dequeue();
        m.dequeue();
        m.dequeue();
        m.dequeue();
        SelfCheckOut s = new SelfCheckOut();
        s.enqueue(new Product("Pen", 25));
        s.enqueue(new Product("Pencil", 10));
        s.enqueue(new Product("Ruler", 20));
        s.enqueue(new Product("Eraser", 15));
        s.enqueue(new Product("Pencil Box", 30));
        s.dequeue();
        s.dequeue();
        s.dequeue();
        s.dequeue();
        s.dequeue();
        System.out.println("Total amount = " + s.getAmount());
    }
    
}
