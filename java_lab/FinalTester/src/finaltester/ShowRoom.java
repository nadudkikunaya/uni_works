/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class ShowRoom implements RoomSpace{
    private String name;
    private int income = 0;
    private ArrayList <Vehicle> vList;
    public ShowRoom (String n) {
        this.vList = new ArrayList<Vehicle>();
        name = n;
    }
    public int getIncome() {
        return income;
    }
    public String getName() {
        return name;
    }
    public void show(Vehicle v){
	if(v instanceof Car){
		if(isVacant(v))
		vList.add(v);
                else
                System.out.println("Showroom is full");
	}
	else if(v instanceof Motorcycle){
		if(isVacant(v))
			vList.add(v);
		else
			System.out.println("Showroom is full");
}
}
    
    public boolean isVacant(Vehicle v){
	if(v instanceof Car){
		if(getNumCar() < 10)
			return true;
		else
			return false;
}
else{
	if(getNumMotorcycle() < 10)
		return true;
	else
		return false;
}
}
    
        public int getNumMotorcycle() {         
int cnt = 0;
		for(Vehicle v : vList){
		   if(v instanceof Motorcycle)
			cnt++;
}
return cnt;
    }    

        public int getNumCar() {
int cnt = 0;
		for(Vehicle v : vList){
		   if(v instanceof Car)
			cnt++;
}
return cnt;

    }

    public void sell(String lp) { 
	for(Vehicle v : vList){
		if(v.getLicensePlate().equals(lp)){
			income += v.getPrice()*0.1;
			vList.remove(v);
			break;
}
}
}


}

