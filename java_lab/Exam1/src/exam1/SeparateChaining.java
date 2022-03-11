
package exam1;

public class SeparateChaining {
  private LinkedList[] table;
  private int size = 0;
  
  public SeparateChaining(int m) {
    LinkedList[] table = new LinkedList[m];
    for (int i=0; i<table.length; i++)
      table[i] = new LinkedList();
  }
  public int size() {
    return size;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public boolean contains(Object e) {
    return table[h(e)].contains(e);
  }
  
  public LinkedList index(int index){
      return table[h(e)];
  }
  public void add(Object e) {
    table[h(e)].add(0, e);
    ++size;
    if (size / table.length >= 5) rehash();
  }
  public void remove(Object e) {
    int i = h(e);
    int s = table[i].size();
    table[i].remove(e);
    if (s > table[i].size()) size--;
  }
  private void rehash() {
    LinkedList[] oldTable = table;
    table = new LinkedList[2 * table.length];
    for (int i = 0; i < table.length; i++)
      table[i] = new LinkedList();
    for (int i = 0; i < oldTable.length; i++) {
      Object[] items = oldTable[i].toArray();
      for (int j = 0; j < items.length; j++) {
        table[h(items[j])].add(0, items[j]);
      }
    }
  }

  private int h(Object x) {
    return Math.abs(x.hashCode()) % table.length;
  }
}



