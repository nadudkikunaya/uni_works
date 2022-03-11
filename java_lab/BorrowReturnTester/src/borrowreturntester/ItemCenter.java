/*

6334422923 Natthawat Hayamin


*/
package borrowreturntester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class ItemCenter extends BorrowReturnCenter{
    public ItemCenter(String name){
        super(name);
    }
    
    @Override
    public void borrow(ArrayList<Integer> itemIDList, int customer){
        double total = 0;
        for(int itemID : itemIDList){
            for(Object x : itemList){
                Item item = (Item)x;
                if(item.getID() == itemID){
                    if(item.getCustID() == -1){
                        item.setCustID(customer);
                        total += item.getValue();
                    }                        
                }
            }
        }
        System.out.println("Customer " + customer + " Borrow completely");
        System.out.println("Total payment : " + total);
        this.addIncome(total);
    }
    
    @Override
    public void displayItem(){
        System.out.println("Available items");
        for(Object x : itemList){
            Item item = (Item)x;
            if(item.getCustID() == -1){
                System.out.println(item.getID() + " " + item.getName() + " " + item.getValue());
            }
        }
    }
    
    @Override
    public void Return(int customerID){
        System.out.println("Customer " + customerID + " Return completely");
        for(Object x : itemList){
            Item item = (Item)x;
            if(item.getCustID() == customerID){
                item.setCustID(-1);
            }
        }
    }
}
