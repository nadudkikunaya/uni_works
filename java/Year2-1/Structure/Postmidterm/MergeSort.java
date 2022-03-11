
package lab11;

public class MergeSort {
    public MergeSort(int[] input, boolean reverse){
        int len = input.length;
        if(len == 0) System.out.println("MergeSort: input is empty!");
        else if(len == 1) return;
        sort(input, 0, len-1,reverse);
    }
    
    private void sort(int[] input,int first,int last,boolean reverse){
        int mid;
        if(first<last){
            mid = (first+last)/2;
            sort(input,first,mid,reverse);
            sort(input,mid+1,last,reverse);
            merge(input,first,mid,mid+1,last,reverse);
        }   
    }
    
    private void merge(int[] input,int leftF,int leftL,int rightF,int rightL,boolean reverse){
        int[] arr = new int[input.length];
        int rememLeftF,index;
        boolean compare;
        rememLeftF = leftF;
        index = leftF;

        while((leftF <= leftL) && (rightF <= rightL)){
            //check reverse
            if(!reverse) compare = input[leftF] > input[rightF];
            else compare = input[leftF] < input[rightF];
            //compare
            if(compare){
                arr[index] = input[rightF];
                rightF = rightF + 1;
            }else{
                arr[index] = input[leftF];
                leftF = leftF+1;
            }
            index++;
        }
        while(leftF <= leftL){
            arr[index] = input[leftF];
            leftF++;
            index++;
        }
        while(rightF <= rightL){
            arr[index] = input[rightF];
            rightF++;
            index++;
        }
        for(index=rememLeftF ; index <= rightL ; index ++){
            input[index] = arr[index];
        }        
    }
}
