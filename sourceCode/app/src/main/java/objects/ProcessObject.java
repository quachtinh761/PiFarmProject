package objects;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import function.StringHanding;

/**
 * Created by Van Thi on 12/29/2016.
 */

public class ProcessObject {
    private String name;
    private int Type; //if 0 is parent import, 1 is parent have child, 2 is child
    private int nDay;
    private Date dateOfBirth;
    private List<String> lsVaccineID = new LinkedList<>();
    private boolean haveUse;

    public ProcessObject(String name, int type, int nDay, Date dateOfBirth, String lsVaccineID, boolean haveUse){ //this list vaccine type $vaccine1#vaccine2$
        this.name = name;
        this.Type = type;
        this.nDay = nDay;
        this.dateOfBirth = dateOfBirth;
        String[] temp = StringHanding.getArrayStr(lsVaccineID);
        for (int i = 0; i < temp.length; i++){
            this.lsVaccineID.add(temp[i]);
        }
        this.haveUse = haveUse;
    }

    public ProcessObject(String name, int type, int nDay, Date dateOfBirth, List<String> lsVaccineID, boolean haveUse) {
        this.name = name;
        Type = type;
        this.nDay = nDay;
        this.dateOfBirth = dateOfBirth;
        this.lsVaccineID = lsVaccineID;
        this.haveUse = haveUse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHaveUse() {
        return haveUse;
    }

    public void setHaveUse(boolean haveUse) {
        this.haveUse = haveUse;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getnDay() {
        return nDay;
    }

    public void setnDay(int nDay) {
        this.nDay = nDay;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getLsVaccineID() {
        return lsVaccineID;
    }

    public void setLsVaccineID(List<String> lsVaccineID) {
        this.lsVaccineID = lsVaccineID;
    }
}
