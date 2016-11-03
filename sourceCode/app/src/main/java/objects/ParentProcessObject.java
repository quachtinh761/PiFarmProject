package objects;

import java.util.Date;
import java.util.List;

/**
 * Created by vanthi on 11/3/2016.
 */

public class ParentProcessObject extends ProcessObject {
    int numberVaccineImport,numberVaccineWhenHaveChild;
    Date dateBeginVaccinImport,dateBeginVaccineWhenHaveChild;

    //list vaccine is Vaccine Import first and then is vaccine when have child
    public ParentProcessObject(int numberVaccineImport, int numberVaccineWhenHaveChild, Date dateBeginVaccinImport, Date dateBeginVaccineWhenHaveChild,
                               List<String> vaccineAll) {
        this.numberVaccineImport = numberVaccineImport;
        this.numberVaccineWhenHaveChild = numberVaccineWhenHaveChild;
        this.dateBeginVaccinImport = dateBeginVaccinImport;
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
        setVaccine(vaccineAll);
    }
    public ParentProcessObject(int numberVaccineImport, int numberVaccineWhenHaveChild, Date dateBeginVaccinImport, Date dateBeginVaccineWhenHaveChild,
                               String[] vaccineAll) {
        this.numberVaccineImport = numberVaccineImport;
        this.numberVaccineWhenHaveChild = numberVaccineWhenHaveChild;
        this.dateBeginVaccinImport = dateBeginVaccinImport;
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
        for (int i=0;i<vaccineAll.length;i++){
            addVaccine(vaccineAll[i]);
        }
    }
    public ParentProcessObject(Date dateBeginVaccinImport, Date dateBeginVaccineWhenHaveChild, List<String> vaccineImport, List<String> VaccineWhenHaveChild) {
        this.numberVaccineImport = vaccineImport.size();
        this.numberVaccineWhenHaveChild = VaccineWhenHaveChild.size();
        this.dateBeginVaccinImport = dateBeginVaccinImport;
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
        setVaccine(vaccineImport);
        for (String p: VaccineWhenHaveChild) {
            addVaccine(p);
        }
    }

    public void addVaccineImport(String Vaccine){
        addVaccine(numberVaccineImport-1,Vaccine);
        numberVaccineImport++;
    }
    public void addVaccineWhenHaveChild(String Vaccine){
        addVaccine(Vaccine);
        numberVaccineWhenHaveChild++;
    }


    public int getNumberVaccineImport() {
        return numberVaccineImport;
    }

    /*public void setNumberVaccineImport(int numberVaccineImport) {
        this.numberVaccineImport = numberVaccineImport;
    }*/

    public int getNumberVaccineWhenHaveChild() {
        return numberVaccineWhenHaveChild;
    }

    /*public void setNumberVaccineWhenHaveChild(int numberVaccineWhenHaveChild) {
        this.numberVaccineWhenHaveChild = numberVaccineWhenHaveChild;
    }*/

    public Date getDateBeginVaccinImport() {
        return dateBeginVaccinImport;
    }

    public void setDateBeginVaccinImport(Date dateBeginVaccinImport) {
        this.dateBeginVaccinImport = dateBeginVaccinImport;
    }

    public Date getDateBeginVaccineWhenHaveChild() {
        return dateBeginVaccineWhenHaveChild;
    }

    public void setDateBeginVaccineWhenHaveChild(Date dateBeginVaccineWhenHaveChild) {
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
    }
}
