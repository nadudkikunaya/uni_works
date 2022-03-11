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
public class Kite extends Quadrilateral{
    public Kite(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        super(x1,y1,x2,y2,x3,y3,x4,y4);
    }

    @Override
    public double area(){
        double[] dis = this.getSortedDist();
        double total = 1;
        for(int i=0;i<6;i++){
            for(int j=i+1;j<6;j++){
                if(dis[i] == dis[j]){
                    dis[i] = 0;
                    dis[j] = 0;
                }
            }
        }
        for(double val : dis){
            if(val != 0)
                total *= val;
        }
        return total/2;
    }
    
}
