/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salestest;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
class Sales {
    private int weekNumber;
    private ArrayList<ArrayList<Double>> weekSales;
    
    public Sales(int n){
        this.weekNumber = n;
        this.weekSales = new ArrayList<>();
        ArrayList<Double> dayInWeek = new ArrayList<>();
        dayInWeek.add(Double.NaN);
        for(int i=0;i<7;i++)
            weekSales.add(dayInWeek);
    }
    
    public void add(int day, double[] hourlySales){
        ArrayList<Double> dayInWeek = new ArrayList<>();
        if(validated(day,hourlySales.length)){
            for(double total : hourlySales){
                dayInWeek.add(total);
            }
            weekSales.set(day, dayInWeek);
        }
        else
            System.out.println("*** Adding error : invalid day or invalid hourlysales ***");
    }
    
    public double sumDailySales(int day){
        double sum = 0;
        if((day >= 0 && day <= 6) && weekSales.get(day).size() > 1 ){
            for(double total : weekSales.get(day)){
                sum += total;
            }
        }
        else
        {
            System.out.println("There is no data on day : " + day);
            return Double.NaN;
        }
        return sum;
    }
    
    public double averageHourlySales(int hour){
        double  sum = 0;
        int dayNum = 0;
        if(hour >= 11 && hour <= 13){
            sum += weekSales.get(0).get(hour);
            sum += weekSales.get(5).get(hour);
            sum += weekSales.get(6).get(hour);
            dayNum = 3;
        }
        else if(hour >= 0 && hour <= 10){
            for(int i = 0; i < 7 ; i++){
                sum += weekSales.get(i).get(hour);
                dayNum = 7;
            }
        }
        else
        {
            System.out.println("The shop doesn't open on hour : " + hour);
            return Double.NaN;
        }
        return sum/dayNum;
    }
    
    public int getTopSalesDay(){
        double max = 0;
        double sum = 0;
        int day = 0;
        for(int i = 0 ; i < 7 ; i++){
            sum = this.sumDailySales(i);
            if(sum > max){
                max = sum;
                day = i;
            }
        }
        return (int)day;
    }
    
    public int getTopSaleHour(){
        double sum = 0;
        double max = 0;
        int hour = 0;
        for(int i=0;i<14;i++){
            sum = this.averageHourlySales(i);
           if(sum > max){
               max = sum;
               hour = i;
           }
        }
        return (int)hour;
    }
    
    public String toString(){
        String data = weekNumber + "\n";
        int cntDay = 0;
        for(ArrayList<Double> dayInWeek : weekSales){
            data += "Day " + cntDay + ":\t";
            for(double total : dayInWeek){
                data += total + "\t";
            }
            data += "\n";
            cntDay++;
        }
        return data;
    }
    private boolean validated(int day,int length){
        boolean case1 = (day == 0 || day == 5 || day == 6 ) && length == 14;
        boolean case2 = (day == 1 || day == 2 || day == 3 || day == 4) && length == 11;
        return case1 || case2;
    }
    
    public int getWeekNumber(){
        return weekNumber;
    }
    
}
