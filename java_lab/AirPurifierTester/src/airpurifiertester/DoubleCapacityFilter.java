package airpurifiertester;
//คลาสลูก extends มาจากคลาส Filter เป็นไส้กรองที่มีความสามารถในการกรองได้เป็นสองเท่าของไส้กรองในคลาสพ่อ
public class DoubleCapacityFilter extends Filter {
    private static final int START_CAPACITY = 20000;
    
    public DoubleCapacityFilter() {        
        currentCapacity = START_CAPACITY;        
    }
}
