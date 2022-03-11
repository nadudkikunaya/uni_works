public class LinkedCollection implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next){
            this.element = e;
            this.next = next;
        }
    }

    private LinkedNode first;
    private int size;
    
    public LinkedCollection(){
        first = null;
        size = 0;
    }

    public int size(){ return size; }

    public boolean isEmpty(){ return size == 0; }

    public void add(Object e){
        LinkedNode n = new LinkedNode(null, null);
        n.element = e;
        n.next = first;
        first = n;
        ++size;
    }

    public boolean contains(Object e){
        LinkedNode node = first;
        while(node != null){
            if(node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }

    public void remove(Object e){
        if(first == null) return;
        if(first.element.equals(e)){
            first = first.next;
            --size;
        }
        else{
            LinkedNode p = first;
            while(p.next != null && !p.next.element.equals(e)){
                p = p.next;
            }
            if(p.next != null){
                p.next = p.next.next;
                --size;
            }
        }
    }
}
