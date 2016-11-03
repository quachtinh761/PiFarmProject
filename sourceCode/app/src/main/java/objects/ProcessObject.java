package objects;

import java.util.List;

import function.processStringPredefined;

/**
 * Created by vanthi on 11/3/2016.
 */

public abstract class ProcessObject {
    private List<String> IDvaccine;
    private List<String> spaceVaccine;
    private String ID, Name;

    //return array with $IDVaccine#spaceVaccine$
    public String[] getVaccine() {
        return processStringPredefined.setStrProcess(IDvaccine,spaceVaccine);
    }

    public void addVaccine(String IDVaccine,String space) {
        this.IDvaccine.add(IDVaccine);
        this.spaceVaccine.add(space);

    }
    public void addVaccine(int i,String IDVaccine,String space) {
        this.IDvaccine.add(i,IDVaccine);
        this.spaceVaccine.add(i,space);

    }
    public void setVaccine(List<String> IDVaccine,List<String> space) {
        this.IDvaccine = IDVaccine;
        this.spaceVaccine = space;

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
