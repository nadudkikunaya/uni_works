/*
 * �ç���ҧ������ : ��Ѻ�Ҩ���
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
package selecteditemtester;
/**
 *
 * @author INatZ
 */
public class LinkedCollectionWithHeader implements Collection {
  private static class LinkedNode {
    Object element;
    LinkedNode next;
    LinkedNode(Object e, LinkedNode next) {
      this.element = e;
      this.next = next;
    }
  }
  private LinkedNode header = new LinkedNode(null, null);
  private int size = 0;
  
  public LinkedCollectionWithHeader() {
    size = 0;
  }
  public int size() {
    return size;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public void add(Object e) {
    header.next = new LinkedNode(e, header.next);
    ++size;
  }
  public boolean contains(Object e) {
    LinkedNode node = header.next;
    while( node != null ) {
      if(node.element instanceof SelectedItem && e instanceof SelectedItem){
          SelectedItem a = (SelectedItem)node.element;
          SelectedItem b = (SelectedItem)e;
          if(a.equals(b))
              return true;
      }
      else if (node.element.equals(e)) return true;
      node = node.next;
    }
    return false;   
  }
  public void remove(Object e) {
    LinkedNode p = header;
    while( p.next != null &&
           ! p.next.element.equals(e)) {
      p = p.next;
    }
    if (p.next != null) {
      p.next = p.next.next; --size;
    }
  }
  public Object[] toArray() {
    Object[] arr = new Object[size];
    LinkedNode p = header.next;
    int k = 0;
    while (p != null) {
      arr[k++] = p.element;
      p = p.next;
    }
    return arr;
  }
  
  public boolean equals(ArrayCollection x){
      ArrayCollection y = x;
      LinkedNode node = header.next;
      if(x.size() != size)
          return false;
      else{
          for(int i = 0 ; i < size ; i++){ 
              if(!y.contains(node.element))
                  return false;
              y.remove(node.element);
              node = node.next;
          }
      }
      return true;
      
  }
  
  public ArrayCollection toArrayCollect(){
      ArrayCollection ac = new ArrayCollection(2);
      LinkedNode node = header.next;
      int i = 0;
      for(i = 0 ; i < size ; i++){
          ac.add(node.element);
          node = node.next;
      }
      return ac;
  }
  
  @Override
  public String toString(){
    String str = "";
    LinkedNode node = header.next;
    int i = 0;
    while(i < size){
        str = str + "<" + node.element + "," + node.next + ">" + "\n";
        node = node.next;
        i++;
    }
    return str;
  }
  
}  
