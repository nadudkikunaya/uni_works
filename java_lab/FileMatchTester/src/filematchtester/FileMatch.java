/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filematchtester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author INatZ
 */
public class FileMatch {
    private ArrayList<AccountRecord> listAccRec;
    private ArrayList<TransactionRecord> listTransRec;
    public FileMatch(){
        listAccRec = new ArrayList<>();
        listTransRec = new ArrayList<>();
        //System.out.println("Start INIT");
        init();
        //System.out.println("Start MATCH");
        match();
        //System.out.println("Start READDATA");
        readData();
    }
    
    private void init(){
        String fileName_master = "master.txt";
        String fileName_trans = "trans.txt";
        File master = new File(fileName_master);
        File trans = new File(fileName_trans);
        Scanner  sc_master;
        Scanner sc_trans;

        try {

            sc_master = new Scanner(master);
            sc_trans = new Scanner(trans);
                        
            //get AccRed data
            while(sc_master.hasNext()){
                
                int accNo = Integer.parseInt(sc_master.next());
                String name = sc_master.next() + " " + sc_master.next();
                double balance = Double.parseDouble(sc_master.next());
                AccountRecord newAcc = new AccountRecord(accNo, name, balance);
                //System.out.println(accNo+","+name+","+balance); //OUTPUT CHECK
                this.listAccRec.add(newAcc);
            }
            // get TransRec data
            while(sc_trans.hasNext()){
                int accNo = Integer.parseInt(sc_trans.next());
                double balance = Double.parseDouble(sc_trans.next());
                //System.out.println(accNo +","+balance); //OUTPUT CHECK
                TransactionRecord transRec = new TransactionRecord(accNo,balance);
                this.listTransRec.add(transRec);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Can not read the file ");
        }
    }
    
    private void match(){
        String fileName = "newMaster.dat";
        RandomAccessFile r = null;
        for(int i=0;i<this.listAccRec.size();i++){
            for(int j=0;j<this.listTransRec.size();j++){
                AccountRecord ac = this.listAccRec.get(i);
                TransactionRecord tr = this.listTransRec.get(j);
                if( ac.getAcctNo() == tr.getAccNo() ){
                    ac.combine(tr);
                    //System.out.println(ac.getAcctNo()+","+ tr.getAmtTrans() +","+ac.getBalance() ); //OUTPUT CHECK
                }
            }
        }
        
        try{
            r = new RandomAccessFile(fileName,"rw");
            for(AccountRecord ac : this.listAccRec){

                String name = ac.getName();
                for(int i=1;i<=30-ac.getName().length();i++){
                    name = name + " ";
                }
                r.writeInt(ac.getAcctNo()); //4                
                r.writeBytes(name); // 30
                r.writeDouble(ac.getBalance()); //8
                r.writeInt(ac.getTransCnt()); //4
                r.writeByte('\n'); //1 
                // ALL = 47
                //System.out.println(name+","+name.length()+","+r.length()); // OUTPUT CHECK
            }
            r.close();
        } catch(IOException ex){
            System.out.println("Can not write to file <<" + fileName + ">>");
        }
    }
    
    private void readData(){
        String fileName = "newMaster.dat";
        RandomAccessFile r = null;
        int currentAcc = 0;
        final int dataPerAcc = 47;
        double total = 0;
        int cntNoTrans = 0;
        try {
            r = new RandomAccessFile(fileName,"rw");
            for(int i=0;i<r.length();i+=dataPerAcc){
                r.seek(i+34);
                double balance = r.readDouble();
                total += balance;
                if(r.readInt() == 0){
                    cntNoTrans++;
                }
                
            }
            System.out.println("Total Account Record : " + r.length()/dataPerAcc);
            System.out.println("Total balance : " + total);
            System.out.println("No transaction : " + cntNoTrans + " account.");
        } catch (FileNotFoundException ex) {
             System.out.println("Can not write to file <<" + fileName + ">>");
        } catch (IOException ex){
            System.out.println("Can not get the length of <<" + fileName + ">>");
        }

        
    }
    
}
