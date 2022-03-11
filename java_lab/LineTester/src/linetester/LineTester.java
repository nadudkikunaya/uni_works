/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linetester;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;

/**
 *
 * @author INatZ
 */
public class LineTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Line line1 = new Line(-2,1,1,-2);
        Line line2 = new Line(-6,-2,-2,0);
        DecimalFormat ff = new DecimalFormat("0.00");
        System.out.print("Are the two lines equals?: ");
        System.out.println(line1.equals(line2));
        System.out.print("Are the two lines parallel?: ");
        System.out.println(line1.isParallel(line2));
        System.out.print("Do the two lines intersect?: ");
        System.out.println(line1.isIntersect(line2));
        Point2D.Double obj = line1.getIntersectionPoint(line2);
        if(obj.getX() != 0 && obj.getY() != 0)
        {
            System.out.print("Point of intersection: ");
            System.out.println(ff.format(obj.getX()) + "," + ff.format(obj.getY()));
        }
        
    }
    
}
