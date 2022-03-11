public class LinkedSet extends LinkedCollection implements Set {

    public LinkedSet(){
        super();
    }

    public void add(Object element){
        if(!contains(element)){
            super.add(element);
        }
    }
}