
package lab12;


public class Main {


    public static void main(String[] args) {
        Graph g = new Graph(10);
        for(int i = 0 ; i < 6 ; i++){
            char character = (char)('A'+i);
            g.addVertex(character);
        }
        
        g.addEdge(new Vertex('A'), new Vertex('B'), 5);
        g.addEdge(new Vertex('A'), new Vertex('C'), 5);
        g.addEdge(new Vertex('A'), new Vertex('D'), 8);
        
        g.addEdge(new Vertex('B'), new Vertex('C'), 6);
        g.addEdge(new Vertex('B'), new Vertex('E'), 5);
        
        g.addEdge(new Vertex('C'), new Vertex('D'), 6);
        g.addEdge(new Vertex('C'), new Vertex('F'), 5);
        g.addEdge(new Vertex('C'), new Vertex('E'), 5);
        
        g.addEdge(new Vertex('D'), new Vertex('F'), 5);
        
        g.deleteVertex(new Vertex('F'));
        g.printMatrix();
        
        g.bfs(new Vertex('G'));
        g.dfs(new Vertex('G'));
    }
    
}
