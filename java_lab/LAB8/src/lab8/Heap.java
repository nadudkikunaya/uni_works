package lab8;

public class Heap {
    public Heap(){
        
    }
    
    public void buildHeap(int heapArr[], int numNode){
        for(int i = numNode/2 ; i > 0 ; i--){
            reHeap(heapArr,i,numNode);
        }
    }
    
    public void reHeap(int heapArr[], int root, int numNode){
        int maxChild = 0, tmp;
        boolean isHeap = false;
        while(root * 2 <= numNode && !isHeap){
            if(root * 2 == numNode) 
                maxChild = root*2;
            else if( heapArr[root*2] > heapArr[root*2+1]) 
                maxChild = root*2;
            else 
                maxChild = root*2+1;
            
            if(heapArr[root] < heapArr[maxChild]){
                tmp = heapArr[root];
                heapArr[root] = heapArr[maxChild];
                heapArr[maxChild] = tmp;
                root = maxChild;
            }
            else
                isHeap = true;
        }
    }
    public void printHeap(int heapArr[], int numNode){
        for(int i = 1 ; i <= numNode; i++){
            System.out.print(heapArr[i] + " ");
        }
        System.out.println();
    }
}
