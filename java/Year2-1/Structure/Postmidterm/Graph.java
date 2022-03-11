/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

/**
 *
 * @author INatZ
 */
public class Graph {
    private Vertex[] list;
    private int[][] adjMatrix;
    private int numVertex;
    
    public Graph(int max){
        list = new Vertex[max];
        adjMatrix = new int[max][max];
        numVertex = 0;
    }
    
    public void addVertex(char label){
        list[numVertex] = new Vertex(label);
        numVertex++;
    } 

    public int searchIndex(Vertex v){
        for(int i = 0 ; i < numVertex ; i++){
            if(v.getTitle() == list[i].getTitle())
                return i;
        }
        return -1;
    }
        
    public void addEdge(Vertex from, Vertex to, int w){
        int fromIndex = searchIndex(from);
        int toIndex = searchIndex(to);
        if(fromIndex != -1 && toIndex != -1){
            adjMatrix[fromIndex][toIndex] = w;
            adjMatrix[toIndex][fromIndex] = w;
        }
        else{
            System.out.println("Edge cannot be created, the vertex isn't exist");
        }
    }
    
    public void deleteEdge(Vertex from, Vertex to){
        addEdge(from, to, 0);
    }
    
    public void deleteVertex(Vertex v){
        int index = searchIndex(v);
        if(index == -1)
            System.out.println("Cannot delete vertex, the vertex isn't exist");
        else{
            for(int i = index ; i < numVertex-1 ; i++){
                list[i] = list[i+1];
            }
            for(int i = index ; i < numVertex-1 ; i++){
                for(int j = 0 ; j < numVertex ; j++){
                    adjMatrix[i][j] = adjMatrix[i+1][j];
                }
            }
            numVertex--;
        }
 
    }
    
    public boolean bfs(Vertex v){
        Vertex start = list[0];
        ArrayQueue q = new ArrayQueue(10);

        q.enqueue(start);
        System.out.println("*BFS*");
        do{          
            Object x = q.dequeue();
            if(x == null) break;
            Vertex tmp = (Vertex)x;
            
                
            if(tmp.getTitle() ==  v.getTitle()){
                resetVisit();
                return true;
            }
            if(!tmp.getVisit()){
                System.out.print(tmp.getTitle() + " ");
                tmp.setVisit(true);
            }

            int tmpIndex = searchIndex(tmp);
            for(int i = 0 ; i < numVertex ; i++){
                if(adjMatrix[tmpIndex][i] != 0){ 
                    if(!list[i].getVisit()){
                        q.enqueue(list[i]);
                    }
                }
            }
        }while(!q.isEmpty());
        System.out.println("");
        resetVisit();
        return false;
        
    }
    
    public boolean dfs(Vertex v){
        Vertex start = list[0];
        ArrayStack st = new ArrayStack(10);
        st.push(start);
        System.out.println("*DFS*");
        do{          
        Vertex tmp = (Vertex)st.pop();
        if(tmp.getTitle() == v.getTitle()){
            resetVisit();
            return true;
        }
        if(!tmp.getVisit()){
            System.out.print(tmp.getTitle() + " ");
            tmp.setVisit(true);
        }
        int tmpIndex = searchIndex(tmp);
        for(int i = 0 ; i < numVertex ; i++)
            if(adjMatrix[tmpIndex][i] != 0) 
                if(!list[i].getVisit())
                    st.push(list[i]);
        }while(!st.isEmpty());
        System.out.println("");
        resetVisit();
        return false;
                
    }
    
    public void printMatrix(){
        System.out.print("# ");
        for(int i = 0 ; i < numVertex ; i++)
            System.out.print(list[i].getTitle() + " ");
        System.out.println();
        
        for(int i = 0 ; i < numVertex ; i++){
            System.out.print(list[i].getTitle() + " ");
            for(int j = 0 ; j < numVertex; j++){
               System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void resetVisit(){
        for(int i = 0 ; i < numVertex ; i++)
            list[i].setVisit(false);
    }
    
}
