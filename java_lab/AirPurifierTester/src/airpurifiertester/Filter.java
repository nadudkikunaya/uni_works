package airpurifiertester;
//คลาสไส้กรองในเครื่องฟอกอากาศ
public class Filter {
    protected static final int START_CAPACITY = 10000; //ความสามารถตั้งต้นในการกรองของไส้กรองว่ากรองอากาศได้กี่หน่วย (ไส้กรองอันใหม่ยังไม่เคยถูกใช้)
    protected int currentCapacity; //ความสามารถในการกรอง ณ ปัจจุบันหลังจากไส้กรองถูกใช้ไปแล้ว
    
    public Filter() {
        currentCapacity = START_CAPACITY;        
    }
    //กรองอากาศ ดังนั้นจะลดค่า currentCapacity ลงตามปริมาณอากาศที่กรอง
    public void filter(int airVolumnInLiter) {
        this.currentCapacity = Math.max(0, currentCapacity - airVolumnInLiter);
    }
    
    public int getCurrentCapacity() {
        return currentCapacity;
    }
    
    public String getFilterType() {
        return getClass().getSimpleName();
    }
    
    public String toString() {
        return "[" + getFilterType() + "] Current Capacity: " + getCurrentCapacity();
    }
}
