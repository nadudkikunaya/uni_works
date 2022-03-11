/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentfiletester;

import java.util.ArrayList;

/**
 *
 * @author INatZ
 */
public class Registration {
    private String ID;
    private ArrayList<String> cIDList = new ArrayList<String> ();	
    public Registration (String ID, ArrayList <String> cIDList) {
        this.ID = ID;
        for (String cID : cIDList) {
            this.cIDList.add(cID);
        }
    }
    public String getID()				{  return ID;		}
    public ArrayList <String> getCourseList()	{  return cIDList;	}

}
