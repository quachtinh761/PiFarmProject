package objects;

import java.util.List;

/**
 * Created by vanthi on 11/3/2016.
 */

public class ChildProcessObject extends ProcessObject {
    String dateBeginVaccine;

    public ChildProcessObject(String ID,String name,String dateBeginVaccine, List<String> vaccine) {
        this.dateBeginVaccine = dateBeginVaccine;
        setID(ID);
        setName(name);
        setVaccine(vaccine);
    }
    public ChildProcessObject(String ID,String name,String dateBeginVaccine, String vaccine) {
        this.dateBeginVaccine = dateBeginVaccine;
        setID(ID);
        setName(name);
        addVaccine(vaccine);
    }
    //
    public ChildProcessObject(String ID,String name,String dateBeginVaccine, String[] vaccine) {
        this.dateBeginVaccine = dateBeginVaccine;
        setID(ID);
        setName(name);
        for (int i=0;i<vaccine.length;i++){
            addVaccine(vaccine[i]);
        }

    }

    public String getDateBeginVaccine() {
        return dateBeginVaccine;
    }

    public void setDateBeginVaccine(String dateBeginVaccine) {
        this.dateBeginVaccine = dateBeginVaccine;
    }
}
