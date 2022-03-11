/*
 * �ç���ҧ������ : ��Ѻ�Ҩ���
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
package selecteditemtester;
/**
 *
 * @author INatZ
 */
public class ArrayCollection implements Collection {
  private Object[] elementData;
  private int      size;
  
  public ArrayCollection(int c) {
    elementData = new Object[c];
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  private int indexOf(Object e) {
    for (int i=0; i<size; i++){
      if (elementData[i].equals(e)) 
          return i;
    }
    return -1;
  }
  @Override
  public boolean contains(Object e) {
    return indexOf(e) != -1;
  }
  @Override
  public void remove(Object e) {
    int i = indexOf(e);
    if (i != -1) {
      elementData[i] = elementData[--size];
      elementData[size] = null;
    }
  }
  @Override
  public void add(Object e) {
    if(e == null) throw new IllegalArgumentException();
    ensureCapacity(size + 1);
    elementData[size++] = e;
  }
  private void ensureCapacity(int capacity) {
    if (capacity > elementData.length) {
      int s = Math.max(capacity, 2*elementData.length);
      Object[] arr = new Object[s];
      for(int i = 0; i < size; i++)
        arr[i] = elementData[i];
      elementData = arr;
    }
  }
  public Object[] toArray() {
    Object[] a = new Object[size];
    for (int i=0; i<size; i++) 
      a[i] = elementData[i];
    return a;
  }
  
  public LinkedCollectionWithHeader toLinkedCollect(){
      LinkedCollectionWithHeader link = new LinkedCollectionWithHeader();
      for(int i = 0 ; i < size ; i++)
          link.add(elementData[i]);
      return link;
  }
  
  public boolean equals(LinkedCollectionWithHeader x){
      LinkedCollectionWithHeader y = x;
      if(this.size != x.size())
          return false;
      else{
          for(int i = 0 ; i < this.size ; i++){
              if(!y.contains(this.elementData[i]))
                  return false;
              y.remove(this.elementData[i]);
          }
      }
      return true;
          
      
  }
  
  public String toString(){
      String str = "";
      for(int i = 0 ; i < size ; i++){
          str = str + elementData[i];
          if(i == size-1)
              break;
          str = str + ",";
      }
      return str;
  }
}
