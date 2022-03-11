
package lab11;

public class QuickSort {
    public QuickSort(int[] input, boolean reverse){
        int len = input.length;
        if(len == 0) 
            System.out.println("QuickSort: input is empty!");
        else if(len == 1) 
            return;     
        sort(input, 0, len-1, reverse);    
    }
    
    private void sort(int[] input,int first,int last, boolean reverse){
        int splitpoint;
        if(first<last){ 
            splitpoint = split(input,first,last,reverse);
            sort(input,first,splitpoint-1, reverse);
            sort(input,splitpoint+1,last, reverse);
        }       
    }
    
    private int split(int[] input,int first,int last, boolean reverse){
        int pivot;
        boolean checkLess,checkGreater,compare;
        int rememFirst,temp;
        pivot = input[first];
        rememFirst = first;
        first++;
        do{
            checkLess = true;
            while((first<=last)&&(checkLess)){
                //check reverse
                if(!reverse) compare = input[first]<=pivot;
                else compare = input[first]>pivot;
                //compare
                if(compare)
                    first++;
                else
                    checkLess = false;
                   
            }
            checkGreater = true;
            while((first<=last)&&(checkGreater)){
                //check reverse
                if(!reverse) compare = pivot<=input[last];
                else compare = pivot>input[last];
                //compare
                if(compare)
                    last--;
                else 
                    checkGreater = false;
            }
            if(first<last){
                temp = input[first];
                input[first] = input[last];
                input[last] = temp;
                first++;
                last--;
            }
        }while(first<=last);{
            temp = input[rememFirst];
            input[rememFirst]=input[last];
            input[last] = temp;
            return last;
        }         
    }
    
}
