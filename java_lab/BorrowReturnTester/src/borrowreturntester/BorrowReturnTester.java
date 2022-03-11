/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrowreturntester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class BorrowReturnTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> itemIDList  = new ArrayList <Integer>();
        ItemCenter ic = new ItemCenter("Everything for you");
        ic.addItemList(new Item(1, "Acer Notebook spec I", 500));
        ic.addItemList(new Item(2, "Acer Notebook spec II", 750));
        ic.addItemList(new Item(3, "Lenovo Desktop spec I", 350));
        ic.addItemList(new Item(4, "Lenovo Desktop spec II", 500));
        ic.addItemList(new Item(5, "PlayStation 5", 1000));
        ic.addItemList(new Item(6, "PlayStation 5", 1000));
        ic.addItemList(new Item(7, "Canon EOS M50", 400));
        ic.addItemList(new Item(8, "Fujifilm X-A5", 350));
        ic.addItemList(new Item(9, "Flashlight Canon", 100));
        ic.addItemList(new Item(10, "Camera tripod", 100));

        System.out.println("Welcome to " + ic.getName());
        itemIDList.add(1);
        itemIDList.add(7);
        itemIDList.add(10);
        ic.borrow(itemIDList, 1);	// customer 1 borrows 3 items
        itemIDList.clear();		// clear selected item ids
        ic.displayItem();		// display available items
        
        itemIDList.add(2);
        itemIDList.add(5);
        ic.borrow(itemIDList, 2);	// customer 2 borrows 2 items
        itemIDList.clear();		// clear selected item ids
        ic.displayItem();     		// display available items
        
        ic.Return(1);			// customer 1 returns all items
        ic.displayItem();    		// display available items
      
        ic.Return(2);			// customer 2 returns all items
        ic.displayItem();		// display available items
        
        System.out.println("Total income is " + ic.getIncome());
    }
    
}
