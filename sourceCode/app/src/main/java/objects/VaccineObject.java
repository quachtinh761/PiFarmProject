package objects;

import java.util.Date;

/**
 * Created by vanthi on 11/4/2016.
 */

public class VaccineObject {
    String ID,name,indication,dose,insertedBy,updatedBy;
    Date insertedDate,updatedDate;

    public VaccineObject(String ID, String name, String indication, String dose, String insertedBy, String updatedBy, Date insertedDate, Date updatedDate) {
        this.ID = ID;
        this.name = name;
        this.indication = indication;
        this.dose = dose;
        this.insertedBy = insertedBy;
        this.updatedBy = updatedBy;
        this.insertedDate = insertedDate;
        this.updatedDate = updatedDate;
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

    public String getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate) {
        this.insertedDate = insertedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
