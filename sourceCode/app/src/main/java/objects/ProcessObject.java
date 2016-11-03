package objects;

import java.util.List;

import function.processStringPredefined;

/**
 * Created by vanthi on 11/3/2016.
 */

public abstract class ProcessObject {
    private List<String> IDvaccine;
    private String ID, Name;

    //return array with $IDVaccine1#IDVaccine2$
    public String getVaccine() {
        return processStringPredefined.setStrProcess(IDvaccine);
    }

    public void addVaccine(String IDVaccine) {
        this.IDvaccine.add(IDVaccine);

    }
    public void addVaccine(int i,String IDVaccine) {
        this.IDvaccine.add(i,IDVaccine);
    }
    public void setVaccine(List<String> IDVaccine) {
        this.IDvaccine = IDVaccine;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public int getNumOfVaccine(){
        return IDvaccine.size();
    }
}
