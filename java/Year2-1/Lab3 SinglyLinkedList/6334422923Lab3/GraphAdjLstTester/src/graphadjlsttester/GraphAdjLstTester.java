/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphadjlsttester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphAdjLstTester {

    public static void main(String[] args) {
        try {
        //declare
        File f1 = new File("graph1.txt");
        File f2 = new File("graph2.txt");
        GraphAdjLst graph1 = new GraphAdjLst(getV(f1),getGraphData(f1));
        GraphAdjLst graph2 = new GraphAdjLst(getV(f2),getGraphData(f2));
        
        //process
        System.out.println(graph1.equals(graph2));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found : " + ex.toString());
        }
        
    }
    public static Object[][] getGraphData(File f) throws FileNotFoundException{
        Object[][] edges = null;
        Scanner sc = new Scanner(f);
        long subFirstInt = f.length()-3 ;
        float bytes = 5f;
        int n = Math.round(subFirstInt / bytes);
        int v = sc.nextInt();
        edges = new Object[n][2];
        int i = 0;
        while(sc.hasNextLine()){
            String x = sc.nextLine();
            if(x.isBlank()) continue;
            String[] a = x.split(",",2);
            edges[i][0] = Integer.parseInt(a[0]);
            edges[i][1] = Integer.parseInt(a[1]);
            i++;
        }
        return edges;
    }
    
    public static int getV(File f) throws FileNotFoundException{
        Scanner sc = new Scanner(f);
        return sc.nextInt();
    }
    
}
