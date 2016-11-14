package objects;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vanthi on 11/3/2016.
 */

public class ParentProcessObject{
    private String ID;
    private int nDayAfterImport;
    private Map<String, Integer> listVaccineImport = new HashMap<String, Integer>(); //include IDVaccine and spacedate
    private int nDayAfterCoordination;
    private Map<String, Integer> listVaccineCoordination = new HashMap<String, Integer>(); //include IDVaccine and spacedate

    public ParentProcessObject(String ID, int nDayAfterImport, Map<String, Integer> listVaccineImport, int nDayAfterCoordination, Map<String, Integer> listVaccineCoordination) {
        this.ID = ID;
        this.nDayAfterImport = nDayAfterImport;
        this.listVaccineImport = listVaccineImport;
        this.nDayAfterCoordination = nDayAfterCoordination;
        this.listVaccineCoordination = listVaccineCoordination;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getnDayAfterImport() {
        return nDayAfterImport;
    }

    public void setnDayAfterImport(int nDayAfterImport) {
        this.nDayAfterImport = nDayAfterImport;
    }

    public Map<String, Integer> getListVaccineImport() {
        return listVaccineImport;
    }

    public void setListVaccineImport(Map<String, Integer> listVaccineImport) {
        this.listVaccineImport = listVaccineImport;
    }

    public int getnDayAfterCoordination() {
        return nDayAfterCoordination;
    }

    public void setnDayAfterCoordination(int nDayAfterCoordination) {
        this.nDayAfterCoordination = nDayAfterCoordination;
    }

    public Map<String, Integer> getListVaccineCoordination() {
        return listVaccineCoordination;
    }

    public void setListVaccineCoordination(Map<String, Integer> listVaccineCoordination) {
        this.listVaccineCoordination = listVaccineCoordination;
    }
}