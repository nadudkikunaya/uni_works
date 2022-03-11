public abstract class AbstractTable {
   private Object[] table;
   private int size = 0;
   protected AbstractTable(int m){
    table = new Object[m];
   } 

   public boolean isEmpty(){ return size == 0; }
   public int size(){ return size; }
   public boolean containsKey(Object key){ return table[f(key)] != null; }
   public Object get(Object key){ return table[f(key)]; }
   public Object put(Object key, Object value){
        Object oldValue = get(key);
        table[f(key)] = value;
        if(oldValue == null) ++size;
        return oldValue;
   }
   public void remove(Object x){
        if(table[f(x)] != null) --size;
        table[f(x)] = null;
   }
   protected abstract int f(Object key);
}
