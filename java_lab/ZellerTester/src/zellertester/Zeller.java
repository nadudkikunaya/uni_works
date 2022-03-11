/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zellertester;

/**
 *
 * @author INatZ
 */
public class Zeller {
    private int dayOfMonth; 
    private int month; 
    private int year; 
    public enum Day {
        SUNDAY("Sunday"), MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY("Saturday");
        private final String d;
        Day(String d){
            this.d = d;
        }
        public String getString()
        {
            return this.d;
        }
    };
       
    public Zeller(int q,int m,int j){
        if(m < 3 && m > 0)
        {
            m = 12 + m;
            j -= 1;
        }
        dayOfMonth = q;
        month = m;
        year = j;
    }

    
    public Day getDayOfWeek(){
        Day dayOfWeek = Day.SATURDAY;
        int h;
        int k = year%100;
        int j = year/100;
        h = (dayOfMonth + ((26*(month+1))/10) + k + (k/4) + (j/4) + (5*j))%7;
        switch(h){
            case 0:
                dayOfWeek = Day.SATURDAY;
                break;
            case 1:
                dayOfWeek = Day.SUNDAY;
                break;
            case 2:
                dayOfWeek = Day.MONDAY;
                break;
            case 3:
                dayOfWeek = Day.TUESDAY;
                break;
            case 4:
                dayOfWeek = Day.WEDNESDAY;
                break;
            case 5:
                dayOfWeek = Day.THURSDAY;
                break;
            case 6:
                dayOfWeek = Day.FRIDAY;
                break;
        }
        return dayOfWeek; 
    }
    
}
