/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeintervaltester;

/**
 *
 * @author INatZ
 */
public class TimeInterval {
    private String start;
    private String end;
    private int min;
    private int hour;
    TimeInterval(String start,String end){
        this.start =  start;
        this.end = end;
        int minStart = Integer.parseInt(this.start.substring(2)) ;
        int minEnd = Integer.parseInt(this.end.substring(2));
        int hourStart = Integer.parseInt(this.start.substring(0, 2));
        int hourEnd = Integer.parseInt(this.end.substring(0,2));
        //System.out.println(minStart + " " + minEnd + " " + hourStart + " " + hourEnd);
        int minInterval = (60-minStart) + minEnd;
        this.min = minInterval % 60;
        this.hour = ((hourEnd - hourStart) - 1) + (minInterval/60);
    }
    public int getMinutes(){
        return min;
    }
    public int getHours(){
        return hour;
    }
}


