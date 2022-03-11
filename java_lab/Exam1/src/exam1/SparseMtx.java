
package exam1;

public class SparseMtx {
    SparseVector[] rows;
    public SparseMtx(double[][] input){
        int r = input.length;
        int c = input[0].length;
        rows = new SparseVector[r];
        for(int i = 0 ; i < r ; i++)
            rows[i] = new SparseVector(c);
    }
    
    public SparseMtx(int r, int c){
        rows = new SparseVector[r];
        for(int i = 0 ; i < r ; i++)
            rows[i] = new SparseVector(c);
    }
    
    public double[][] to2DArray(){
        double[][] arr = new arr[rows.length][rows[0].length()];
        for(int i = 0 ; i < rows.length ; i++)
            for(int j = 0 ; j < rows[0].length() ; j++)
                arr[i][j] = 
        return arr;
    }
    
    public int numRows () { return rows.length ; }
    public int numCols () { return rows[0].length(); }
    
    public SparseMtx add(SparseMtx m2){
        SparseMtx m1 = this.rows;
        int r = m1.numRows();
        int c = m1.numCols();
        if (r!=m2.numRows() || r!=m2.numCols())
            throw new IllegalArgumentException();
        SparseMtx m3 = new SparseMtx(r,c);
        for (int i =0; i <r; i ++)
        m3.rows[i] = m1.rows[i].add(m2.rows[i]);
        return m3;
    }
    
    
}
