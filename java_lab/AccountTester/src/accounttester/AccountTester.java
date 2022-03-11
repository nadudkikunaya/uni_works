/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttester;

/**
 *
 * @author INatZ
 */
public class AccountTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrepaidAcc myacc = new PrepaidAcc("jaruloj","0991231234",1.0,2.5);
        myacc.load(400);
        myacc.call(50);
        myacc.internetConnect(25000);
        System.out.println(myacc.getName()+" balance = "+ myacc.checkBalance());
        PostpaidAcc youracc=new PostpaidAcc("siri","0556786789",399,0.5,1.5);
        youracc.setCallQuota(100);
        youracc.setInternetQuota(50000);
        youracc.call(250);
        String name = youracc.getName();
        youracc.internetConnect(25000);
        System.out.println(name+" balance = "+ youracc.checkBalance());
        System.out.println(name+" call quota = "+ youracc.getCallQuota());
        System.out.println(name+" internet quota = " +
        youracc.getInternetQuota());
        youracc.setCallQuota(youracc.getCallQuota()+100);
        youracc.internetConnect(35000);
        System.out.println(name+" balance = "+youracc.checkBalance());
        System.out.println(name+" call quota = "+youracc.getCallQuota());
        System.out.println(name+" internet quota = " +
        youracc.getInternetQuota());
    }
    
}
