package objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vanthi on 11/3/2016.
 */

public class ChildProcessObject {
    private String ID;
    private int nDayAfterBorn;
    private Map<String, Integer> lsVaccine = new HashMap<String, Integer>(); //include IDVaccine and spacedate

    public ChildProcessObject(String ID, int nDayAfterBorn, Map<String, Integer> lsVaccine) {
        this.ID = ID;
        this.nDayAfterBorn = nDayAfterBorn;
        this.lsVaccine = lsVaccine;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getnDayAfterBorn() {
        return nDayAfterBorn;
    }

    public void setnDayAfterBorn(int nDayAfterBorn) {
        this.nDayAfterBorn = nDayAfterBorn;
    }

    public Map<String, Integer> getLsVaccine() {
        return lsVaccine;
    }

    public void setLsVaccine(Map<String, Integer> lsVaccine) {
        this.lsVaccine = lsVaccine;
    }
    public boolean equal(ChildProcessObject a){
        return a.getID() == ID;
    }
}