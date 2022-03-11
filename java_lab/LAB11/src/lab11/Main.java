
package lab11;

public class Main {

    public static void main(String[] args) {
        int[] data1 = {15,9,7,16,31,2,20,25,17,12};
        int[] data2 = {5,2,12,9,1,8,7,18};
        QuickSort qs = new QuickSort(data1,false);
        MergeSort ms = new MergeSort(data2,false);
        //print data1 quicksort
        for(int i = 0 ; i < data1.length; i++) System.out.print(data1[i] + " ");
        System.out.println();
        //print data2 mergesort
        for(int i = 0 ; i < data2.length; i++) System.out.print(data2[i] + " ");
        System.out.println();
        
    }
    
}
