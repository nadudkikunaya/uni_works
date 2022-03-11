public class ArraySet extends ArrayCollection implements Set {

    public ArraySet(int c) {
        super(c);
    }

    public void add(Object element){
        if(!contains(element)){
            super.add(element);
        }
    }
    
}
