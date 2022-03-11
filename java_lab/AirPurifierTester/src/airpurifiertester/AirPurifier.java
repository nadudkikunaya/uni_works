package airpurifiertester;

import java.util.ArrayList;
//คลาสเครื่องฟอกอากาศ
public class AirPurifier {
    private ArrayList<Filter> filters; //แทนไส้กรอง
    
    public AirPurifier() {
        filters = new ArrayList<Filter>(); //อาร์เรย์ที่เก็บไส้กรอง โดยขึ้นกับว่าเครื่องกรองตัวนี้จะมีไส้กรองกี่ตัว
    }
    //ใส่ไส้กรองลงในเครื่อง
    public void insertFilter(Filter filter) {
        filters.add(filter);
    }
    //เปลี่ยนไส้กรอง โดยรับเลขช่องในอาร์เรย์ของตัวไส้กรองที่จะเปลี่ยน (index) และรับไส้กรองตัวใหม่ที่จะนำมาเปลี่ยน (filter)
    public void replaceFilterAtIndex(int index, Filter filter) {
        try {
            if (filters.get(index) != null) {
                filters.set(index, filter);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!!!!!Error Cannot replaceFilterAtIndex!!!!!");
        }
    }
    
    //พิมพ์แสดงข้อมูลไส้กรองในเครื่องแต่ละตัว
    public void printFilterDetails() {
        System.out.println("##### Filter Details #####");        
        int i = 0;
        while (i < filters.size()) {
            System.out.print(i + ") ");
            System.out.println(filters.get(i));
            i++;
        }        
        System.out.println("##########################");
        System.out.println();
    }
    
    //กรองอากาศ ในความเป็นจริงประสิทธิภาพไส้กรองมักวัดเป็นเดือน เช่นหกเดือนเปลี่ยนที
    //แต่ในเมธอดนี้สมมติว่าเราวัดประสิทธิภาพไส้กรองจากปริมาณอากาศที่ไหลผ่านเครื่องกรอง (airVolumeInLiter)
    public void filter(int airVolumeInLiter) {
        int i = 0;
        //วนเช็คทีละไส้กรอง
        while (i < filters.size()) {
            int air = airVolumeInLiter;
            Filter f = filters.get(i); //get ไส้กรองต่ละตัวมาใส่ตัวแปร f
            //เอาปริมาณอากาศที่รับเข้ามาลบกับ capacity ของไส้กรองที่เหลืออยู่ ณ ปัจจุบัน 
            //หากปริมาณอากาศมีค่ามากกว่า capacity ของไส้กรองที่เหลืออยู่ ณ ปัจจุบัน จะเอาค่าผลต่างไปใส่ให้ airVolumeInLiter
            //และในรอบถัดไป ไส้กรองตัวอื่นจะฟอกจนกว่า airVolumeInLiter จะเป็นศูนย์
            //หากปริมาณอากาศมีค่าน้อยกว่า capacity ของไส้กรองที่เหลืออยู่ ณ ปัจจุบัน จะเอาศูนย์ไปใส่ให้ airVolumeInLiter             
            airVolumeInLiter = Math.max(0, airVolumeInLiter - f.getCurrentCapacity());
            //ไส้กรองฟอกอากาศ
            f.filter(air);
            if(airVolumeInLiter == 0) break; //airVolumeInLiter เป็นศูนย์แล้วก็ออกจากลูป
            i++;
        }
        //หากใช้ครบทุกไส้กรองแล้ว airVolumeInLiter ยังไม่เป็นศูนย์ขึ้นเตือนว่าต้องเปลี่ยนไส้กรอง
        if (airVolumeInLiter > 0) {
            System.out.println("!!!!!Please replace filter!!!!!");
        }
    }    
    
}
