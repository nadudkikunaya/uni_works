/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissortester;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class Game {
    private int scCounterPlayer = 0;
    private int scCounterCom = 0;
    enum rps {ROCK(0,"ROCK"),PAPER(1,"PAPER"),SCISSORS(2,"SCISSORS");
        private String str;
        private int num;
        rps(int n,String s){
            str = s;
            num = n;
        }
        public String getStr(){
            return str;
        }
        public int getNum(){
            return num;
        }

    }
    
    public void play(){
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        while(Math.abs(scCounterPlayer - scCounterCom) != 2){
            rps player,com;
            int n;
            String inp;
            boolean isWin = false;
            System.out.print("Enter 0 for ROCK, 1 for PAPER, 2 for SCISSORS: ");
            inp = sc.nextLine();
            // check inp
            if(isValidated(inp))
                n = Integer.parseInt(inp);
            else
                continue;
            
            player = convertToRPS(n);
            System.out.println("You enter: " + player.getStr());
            com = convertToRPS(rd.nextInt(3));
            System.out.println("Computer: " + com.getStr());
            
            // Is player winning?
            if(player.getNum() == com.getNum()){
                System.out.println("It's a tie.");
                continue;
            }
            else if(player.getNum() == 0){
                isWin = com.getNum() == 2;
            }
            else if(player.getNum() == 1){
                isWin = com.getNum() == 0;
            }
            else if(player.getNum() == 2){
                isWin = com.getNum() == 1;
            }
            // print result
            if(isWin){
                System.out.println("You win!");
                scCounterPlayer += 1;
            }
            else{
                System.out.println("You lose!");
                scCounterCom += 1;
            }                  
        }
        System.out.println("----------------------------------------");
        if(scCounterPlayer>scCounterCom)
            System.out.println("Congrats! You win.");
        else
            System.out.println("Too bad! You lose.");
        System.out.println("User Score: " + scCounterPlayer);
        System.out.println("Computer score: " + scCounterCom);
        scCounterPlayer = 0;
        scCounterCom = 0;
    }
    
    private boolean isValidated(String s){
        if(s.length() == 1 ){
            if(s.equals("0") || s.equals("1") || s.equals("2"))
                    return true;
                
        }
        return false;
    }
    private rps convertToRPS(int n){
        rps x = rps.ROCK ;
        switch(n){
            case 0:
                x = rps.ROCK;
                break;
            case 1:
                x = rps.PAPER;
                break;
            case 2:
                x = rps.SCISSORS;
                break;
        }
        return x;
    }
    
    
}
