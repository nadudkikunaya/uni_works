/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salestest;

/**
 *
 * @author INatZ
 */
public class SalesTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sales s = new Sales(5);
        double[] hourlySales = {1,2,3,4,5,6,7,8,9,10,11};
        double[] hourlySales2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        double[] hourlySales3 = {10,11,12,13,14,15,16,17,18,19,20};
        double[] hourlySales4 = {15,16,17,18,19,20,21,22,23,24,25,26,27,28};
        s.add(0, hourlySales4);
        s.add(1, hourlySales);
        s.add(2, hourlySales);
        s.add(3, hourlySales3);
        s.add(4, hourlySales);
        s.add(5, hourlySales2);
        s.add(6, hourlySales2);
        /*System.out.println(s.sumDailySales(6));
        System.out.println(s.averageHourlySales(13));
        System.out.println(s.getTopSaleHour());
        System.out.println(s.getTopSalesDay());
        System.out.println(s.toString());
        */
        System.out.println(s.getWeekNumber());
        System.out.println(s.getTopSalesDay());
        System.out.println(s.getTopSaleHour());
    }
    
}
