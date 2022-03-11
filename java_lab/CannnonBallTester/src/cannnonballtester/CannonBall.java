/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cannnonballtester;

import java.text.DecimalFormat;

/**
 *
 * @author INatZ
 */
public class CannonBall {
    private double initV;
    private double simS; 
    private double simT; 
    public static final double g = 9.81;
    DecimalFormat df3 = new DecimalFormat("0.000");
    DecimalFormat df2 = new DecimalFormat("0.00");
    CannonBall(int v){
        initV = v;
        
    }
    public void simulatedFlight(){

        float sec = 0;
        double time = 0.01;
        double v = initV;
        double s = 0;
        double gravity = g;
        while(v>0){
            for(int i=1;i<=100;i++){
                s = v * time;
                simS += s;
                v = v - gravity * time;
                sec += 0.01;
                if(v<=0){
                    simT = Double.parseDouble(df2.format(sec));
                    break;
                }
            }
            //System.out.println(df3.format(s) + " " + df3.format(v));
            if(v>0)
                System.out.println("Distance on " + Math.round(sec) + " sec: " + df3.format(simS));
            else{
                System.out.println("Final distance: " + df3.format(simS) + " Total time: " + df2.format(simT));
            }
        }
    }
    
    public double calculusFlight(double t){
        double calS = -0.5*g*Math.pow(t, 2) + initV*t;
        return Double.parseDouble(df3.format(calS));
    }
    
    public double getSimulatedTime(){
        return simT;
    }
    
    public double getSimulatedDistance(){
        return simS;
    }
    
}
