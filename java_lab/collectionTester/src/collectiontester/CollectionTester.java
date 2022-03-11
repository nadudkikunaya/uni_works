
package collectiontester;

public class CollectionTester {

    public static void main(String[] args) {

        /* arr collection */
//        ArrayCollection test = new ArrayCollection();
//        test.add(5);
//        test.add(4);
//        test.add(3);
//        test.remove(3);

        /* sortedArr collection*/
        SortedArrayCollection sArr = new SortedArrayCollection();
        sArr.add(2); sArr.add(5); sArr.add(3);
        sArr.add(8); sArr.add(12); sArr.add(20);
        sArr.add(20); sArr.add(15);
        //sArr.remove(8);
        sArr.show();


          /* addAfter */
//        LinkedCollection link1 = new LinkedCollection();       
//        link1.add(2); link1.add(4); link1.add(5);
//        System.out.println(link1.size());
//        link1.addAfter(5, 3);
//        link1.show();
//        System.out.println(link1.size());


            /* merge */
//          LinkedCollection link1 = new LinkedCollection();
//          LinkedCollection link2 = new LinkedCollection();
//          link1.add(1); link1.add(2); link1.add(3);
//          link2.add(4); link2.add(5); link2.add(6);
//          link1.show();
//          link2.show();
//          System.out.println("");
//          link1.merge(link2);
//          link1.show();
    }
    
}
