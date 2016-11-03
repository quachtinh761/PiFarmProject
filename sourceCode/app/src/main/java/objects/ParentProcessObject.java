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
                               List<String> vaccineAll,List<String> space) {
        this.numberVaccineImport = numberVaccineImport;
        this.numberVaccineWhenHaveChild = numberVaccineWhenHaveChild;
        this.dateBeginVaccinImport = dateBeginVaccinImport;
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
        setVaccine(vaccineAll,space);
    }
    public ParentProcessObject(int numberVaccineImport, int numberVaccineWhenHaveChild, Date dateBeginVaccinImport, Date dateBeginVaccineWhenHaveChild,
                               String[] vaccineAll,String[] space) {
        this.numberVaccineImport = numberVaccineImport;
        this.numberVaccineWhenHaveChild = numberVaccineWhenHaveChild;
        this.dateBeginVaccinImport = dateBeginVaccinImport;
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
        for (int i=0;i<vaccineAll.length;i++){
            addVaccine(vaccineAll[i],space[i]);
        }
    }
    public ParentProcessObject(Date dateBeginVaccinImport, Date dateBeginVaccineWhenHaveChild, List<String> vaccineImport,List<String> spaceImport,
                               List<String> VaccineWhenHaveChild, List<String> spaceHaveChild) {
        this.numberVaccineImport = vaccineImport.size();
        this.numberVaccineWhenHaveChild = VaccineWhenHaveChild.size();
        this.dateBeginVaccinImport = dateBeginVaccinImport;
        this.dateBeginVaccineWhenHaveChild = dateBeginVaccineWhenHaveChild;
        setVaccine(vaccineImport,spaceImport);
        for (int i=0;i<VaccineWhenHaveChild.size();i++){
            addVaccine(VaccineWhenHaveChild.get(i),spaceHaveChild.get(i));
        }
    }

    public void addVaccineImport(String Vaccine,String space){
        addVaccine(numberVaccineImport-1,Vaccine,space);
        numberVaccineImport++;
    }
    public void addVaccineWhenHaveChild(String Vaccine,String space){
        addVaccine(Vaccine,space);
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
