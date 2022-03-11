/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linetester;

import java.awt.geom.Point2D;

/**
 *
 * @author INatZ
 */

/*
y = mx + b
x = (y - b ) / m
m = (y2-y1)/(x2-x1)
b = y - mx 
*/
public class Line {
    private double slope = Double.NaN;
    private double b = Double.NaN;
    private double cutX = Double.NaN;
    private boolean isVertical = false;
    public Line(double x, double y, double m)
    {
        if(m != 0){
            this.slope = m;
            this.b = y-(m*x);
        }

    }
    
    public Line(double x1, double y1, double x2, double y2)
    {
        if(x1==x2){
            this.isVertical = true;
        }
        else{
            this.slope = (y2-y1) / (x2-x1);
            this.b = y1-(this.slope*x1);
        }

    }
    
    public Line(double m, double b)
    {
        this.slope = m;
        this.b = b;
        
    }
    
    public Line(double a)
    {
        this.cutX = a;
        isVertical = true;
    }
    
    public double getSlope(){
        return this.slope;
    }
    
    public double getB(){
        return this.b;
    }
    
    public double getCutX(){
        return this.cutX;
    }
    
    public boolean isVertical(){
        return this.isVertical;
    }
    
    public boolean isParallel(Line line){
        if(line.getSlope() == this.slope )
            return true;
        else
            return false;
    }
    
    
    public boolean isIntersect(Line line){
        if(!this.isParallel(line))
            return true;
        else
            return false;
    }
    
    
    public boolean equals(Line line){
        if(this.isParallel(line) && (line.b == this.b) )
            return true;
        return false;
    }
    
    public Point2D.Double getIntersectionPoint(Line line){
        Point2D.Double obj = new Point2D.Double();
        double px,py;
        if(this.isIntersect(line)){
            if(!this.isVertical() && !line.isVertical()){
                px = (line.getB() - this.b) / (this.slope - line.getSlope());
                py = (this.slope*px + this.b);
                obj.setLocation(px, py);
            }
            else if(this.isVertical() && !line.isVertical()){
                px = this.cutX;
                py = (line.getSlope()*px) + line.getB();
                obj.setLocation(px, py);
            }
            else if(!this.isVertical() && line.isVertical()){
                px = line.cutX;
                py = this.getSlope()*px+b;
                obj.setLocation(px, py);
            }
        }
        return obj;
    }
    
}
