/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progtech;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class ExampleScanner {
    public static void main(String[] args){
        GregorianCalendar bd = new GregorianCalendar(2000,0,5);
        
    }
    public static void calendar(String[] args){
        GregorianCalendar bd = new GregorianCalendar(2000,Calendar.FEBRUARY+1,5);
        System.out.println("Date: " + bd.get(Calendar.MONTH) + " " + bd.get(Calendar.DATE) + " , " + bd.get(Calendar.YEAR));
        bd.add(Calendar.DATE,24);
        System.out.println("Date: " + bd.get(Calendar.MONTH) + " " + bd.get(Calendar.DATE) + " , " + bd.get(Calendar.YEAR));
    }
    public static void date(String[] args){
        int days, months;
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        
        LocalDate startDate = LocalDate.parse("2020-11-19");
        Period duration = Period.between(startDate, today);
        days = duration.getDays();
        months = duration.getMonths();
        System.out.println(today);
        System.out.println(startDate);
        System.out.println(duration);
        System.out.println("days: "+days+", months: "+months);
        int test = 5;
        System.out.println("Test"+test);
        
        
    }
    public static void scanner(String[] aggs){
        Scanner input = new Scanner(System.in);
        String names = "";
        System.out.println("Enter student name : ");
        names = input.nextLine();
        System.out.println("-->" + names + "<--");
    }
}
