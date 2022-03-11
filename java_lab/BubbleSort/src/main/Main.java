
package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File f = new File("student.txt");
        SinglyLinkedList singly = new SinglyLinkedList();
        LinkedList linkedList = new LinkedList();
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                int id = Integer.parseInt(sc.nextLine());
                singly.add(id);
                linkedList.add(id);
            }
            singly.sort(1);
            linkedList.sort(-1);
            System.out.println(singly.toString());
            System.out.println(linkedList.toString());


        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
