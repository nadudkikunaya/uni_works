
package selecteditemtester;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author INatZ
 */

public class SelectedItemTester {

    public static void main(String[] args) {

        File order1 = new File("order1.txt");
        File order2 = new File("order2.txt");
        ArrayCollection arrc = new ArrayCollection(2);
        LinkedCollectionWithHeader link = new LinkedCollectionWithHeader();
        
        try {
            Scanner sc1 = new Scanner(order1);
            Scanner sc2 = new Scanner(order2);
            while(sc1.hasNext()){
                SelectedItem item = new SelectedItem(sc1.next(),sc1.nextInt());
                arrc.add(item);
            }
            while(sc2.hasNext()){
                SelectedItem item = new SelectedItem(sc2.next(),sc2.nextInt());
                link.add(item);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        
        System.out.println(arrc.equals(link));
        
        
    
    
    }
}