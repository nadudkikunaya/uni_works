/*

6334422923 Natthawat Hayamin


*/
package borrowreturntester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public abstract class BorrowReturnCenter {
    private String name; // shop name
    private double income;
    protected ArrayList <Object> itemList; // store list of items
    public BorrowReturnCenter(String name) {
        this.name = name;
        itemList = new ArrayList <>();
    }
    public String getName() { return name; }
    public void addIncome(double inc) { income += inc; }
    public double getIncome() { return income; }
    public void addItemList(Object o) { itemList.add(o); }
    
    public abstract void borrow(ArrayList<Integer> itemIDList, int customer);
    public abstract void displayItem();
    public abstract void Return(int customerID);
    
    
}
