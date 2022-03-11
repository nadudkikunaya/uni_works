public class LinkedCollectionWithHeader implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next){
            this.element = e;
            this.next = next;
        }
    }

    private LinkedNode header;
    private int size;

    public LinkedCollectionWithHeader(){
        header = new LinkedNode(null, null);
        size = 0;
    }

    public void add(Object e){
        header.next = new LinkedNode(e, header.next);
        ++size;
    }

    public boolean contains(Object e){
        LinkedNode node = header;
        while(node.next != null){
            if(node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }

    public void remove(Object e){
        if(header == null) return;
        if(header.element.equals(e)){
            header = header.next;
            --size;
        }
        else{
            LinkedNode p = header;
            while(p.next != null && !p.next.element.equals(e)){
                p = p.next;
            }
            if(p.next != null){
                p.next = p.next.next;
                --size;
            }
        }
    }

    public boolean isEmpty(){ return size == 0; }
    public int size(){ return size; }

    public Object[] toArray(){
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while(p != null){
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }
}
