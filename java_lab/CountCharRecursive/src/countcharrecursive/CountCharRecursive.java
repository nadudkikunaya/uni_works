/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countcharrecursive;

/**
 *
 * @author INatZ
 */
public class CountCharRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       char[] test = {'A','B','A','C','D','A','F','A','F','B','C','A','D','A','a'};
      System.out.println(count(test, 'A'));

    }

  public static int count(char[] chars,char ch)
{

        return counter(chars, ch, chars.length - 1);
    }

    
public static int counter(char[] chars, char ch, int index){
    int total = 0;
    if(index < 0)
        return 0;
    else{
        if(chars[index] == ch)
            total += 1;
    }
    return total + counter(chars,ch,index-1);
}

    
}
