public class SetCollection implements Set {
    private Collection c;
    public SetCollection(){
        c = new LinkedCollection();
    }

    public boolean isEmpty(){ return c.isEmpty(); }
    public int size(){ return size(); }
    public boolean contains(Object e) { return c.contains(e); }
    public void remove(Object e){ c.remove(e); }
    public void add(Object e){
        if(!contains(e)) c.add(e);
    }
}
