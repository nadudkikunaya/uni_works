import java.util.NoSuchElementException;

public class ArrayListQueue implements Queue {
    private ArrayList list = new ArrayList(10);
    public boolean isEmpty(){ return list.isEmpty(); }
    public int size(){ return list.size(); }
    public void enqueue(Object e){ list.add(e); }
    public Object peek(){
        if(isEmpty()) throw new NoSuchElementException();
        return list.get(0);
    }

    public Object dequeue(){
        Object e = peek();
        list.remove(0);
        return e;
    }
}
