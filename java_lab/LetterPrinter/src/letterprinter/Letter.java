/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterprinter;

/**
 *
 * @author INatZ
 */
public class Letter {
    public String sender;
    public String receiver;
    private String msg = "";
    Letter(String from,String to){
        this.sender = from;
        this.receiver = to;
    }
    public void addLine(String line){
        this.msg = this.msg + "\n" + line;
    }
    public String getText(){
        return this.msg + "\n";
    }
}
