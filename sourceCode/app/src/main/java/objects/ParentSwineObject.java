package objects;

import java.text.ParseException;
import java.util.Date;

import function.DateHanding;

/**
 * Created by vanthi on 11/1/2016.
 */

public class ParentSwineObject {

    private String ID;
    private Date dateImport;
    private String earNumber;
    private Date matingDate;
    private String coordinatorID;
    private Date expectedDateOfBirth;
    private Date realDateOfBirth;
    private int timesOfBirth;
    private int totalChilds;
    private String processID;
    private Date firstVaccineDate;
    private String lsGOAT;
    private int numberChildsDie;

    public ParentSwineObject(String ID, Date dateImport, String earNumber, Date matingDate, String coordinatorID, Date realDateOfBirth, int timesOfBirth, int totalChilds, String processID, Date firstVaccineDate, String lsGOAT, int numberChildsDie, Date expectedDateOfBirth) {
        this.ID = ID;
        this.dateImport = dateImport;
        this.earNumber = earNumber;
        this.matingDate = matingDate;
        this.coordinatorID = coordinatorID;
        this.realDateOfBirth = realDateOfBirth;
        this.timesOfBirth = timesOfBirth;
        this.totalChilds = totalChilds;
        this.processID = processID;
        this.firstVaccineDate = firstVaccineDate;
        this.lsGOAT = lsGOAT;
        this.numberChildsDie = numberChildsDie;
        this.expectedDateOfBirth = expectedDateOfBirth;
    }

    public ParentSwineObject(String ID, String processID, String earNumber, Date dateImport) {
        this.dateImport = dateImport;
        this.earNumber = earNumber;
        this.ID = ID;
        this.processID = processID;
    }

    public ParentSwineObject(String ID, String processID,String earNumber,Date dateImport,Date matingDate)  {
        this.matingDate = matingDate;
        this.expectedDateOfBirth = DateHanding.getDateAfter(dateImport,115);
        this.dateImport = dateImport;
        this.earNumber = earNumber;
        this.ID = ID;
        this.processID = processID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    public String getEarNumber() {
        return earNumber;
    }

    public void setEarNumber(String earNumber) {
        this.earNumber = earNumber;
    }

    public Date getMatingDate() {
        return matingDate;
    }

    public void setMatingDate(Date matingDate) {
        this.matingDate = matingDate;
    }

    public String getCoordinatorID() {
        return coordinatorID;
    }

    public void setCoordinatorID(String coordinatorID) {
        this.coordinatorID = coordinatorID;
    }

    public Date getExpectedDateOfBirth() {
        return expectedDateOfBirth;
    }

    public void setExpectedDateOfBirth(Date expectedDateOfBirth) {
        this.expectedDateOfBirth = expectedDateOfBirth;
    }

    public Date getRealDateOfBirth() {
        return realDateOfBirth;
    }

    public void setRealDateOfBirth(Date realDateOfBirth) {
        this.realDateOfBirth = realDateOfBirth;
    }

    public int getTimesOfBirth() {
        return timesOfBirth;
    }

    public void setTimesOfBirth(int timesOfBirth) {
        this.timesOfBirth = timesOfBirth;
    }

    public int getTotalChilds() {
        return totalChilds;
    }

    public void setTotalChilds(int totalChilds) {
        this.totalChilds = totalChilds;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public Date getFirstVaccineDate() {
        return firstVaccineDate;
    }

    public void setFirstVaccineDate(Date firstVaccineDate) {
        this.firstVaccineDate = firstVaccineDate;
    }

    public String getLsGOAT() {
        return lsGOAT;
    }

    public void setLsGOAT(String lsGOAT) {
        this.lsGOAT = lsGOAT;
    }

    public int getNumberChildsDie() {
        return numberChildsDie;
    }

    public void setNumberChildsDie(int numberChildsDie) {
        this.numberChildsDie = numberChildsDie;
    }
}
