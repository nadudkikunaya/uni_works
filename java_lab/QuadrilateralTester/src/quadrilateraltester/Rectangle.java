/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrilateraltester;

/**
 *
 * @author INatZ
 */
public class Rectangle extends Quadrilateral{
    public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }
    
    @Override
    public double area(){
        double[] dis = this.getSortedDist();
        double a = dis[0];
        double b = 0;
        for(double val : dis){
            if(val != a){
                b = val;
                break;
            }
        }
        return a*b;
    }
    
}
