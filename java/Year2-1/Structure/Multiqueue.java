

public class Multiqueue implements Queue{
    private ArrayQueue[] arr;

    public Multiqueue(int cap){
        arr = new ArrayQueue[cap];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = new ArrayQueue(1);
        }
    }

    public boolean isEmpty(){
        for(int i = 0 ; i < arr.length ; i++)
            if(!arr[i].isEmpty() && arr[i] != null) return false;
        return true;
    }

    public int size(){
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null)
                total += arr[i].size();
        }
        return total;
    }

    public Object dequeue(){
        int max = 0;
        int index = -1;
        int notNull = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null){
                ++notNull;
                if(arr[i].size() > max){
                    max = arr[i].size();
                    index = i;
                }
            }
        }
        if(notNull > 0 && index > -1){
            Object oldV = arr[index].dequeue();
            return oldV;
        }
        else
            return null;
    }

    public void enqueue(Object e){
        int max = 9999999;
        int index = -1;
        int notNull = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null){
                ++notNull;
                if(arr[i].size() < max){
                    max = arr[i].size();
                    index = i;
                }
            }
        }
        if(notNull > 0 && index > -1){
            arr[index].enqueue(e);
        }  
    }

    public Object peek(){
        int max = 0;
        int index = -1;
        int notNull = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null){
                ++notNull;
                if(arr[i].size() > max){
                    max = arr[i].size();
                    index = i;
                }
            }
        }
        if(notNull > 0 && index > -1){
            Object oldV = arr[index].peek();
            return oldV;
        }
        else
            return null;
    }
    
}
