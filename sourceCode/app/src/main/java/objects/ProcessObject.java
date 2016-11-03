package objects;

import java.util.List;

import function.processStringPredefined;

/**
 * Created by vanthi on 11/3/2016.
 */

public class ProcessObject {
    private List<String> IDvaccine;
    private List<String> spaceVaccine;
    private String ID, Name;

    //return array with $IDVaccine#spaceVaccine$
    public String[] getVaccine() {
        return processStringPredefined.setStrProcess(IDvaccine,spaceVaccine);
    }

    public void setVaccine(String IDVaccine,String space) {
        this.IDvaccine.add(IDVaccine);
        this.spaceVaccine.add(space);

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
