/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cannnonballtester;

/**
 *
 * @author INatZ
 */
public class CannnonBallTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CannonBall ball = new CannonBall(100); //initial velocity = 100 m/sec
        ball.simulatedFlight();
        System.out.println("Distance from calculus equation: " + ball.calculusFlight(ball.getSimulatedTime()));
}
    
}
