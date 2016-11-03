package objects;

/**
 * Created by vanthi on 11/4/2016.
 */

public class VaccineObject {
    String ID,name,indication,dose;

    public VaccineObject(String ID, String name, String indication, String dose) {
        this.ID = ID;
        this.name = name;
        this.indication = indication;
        this.dose = dose;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}
