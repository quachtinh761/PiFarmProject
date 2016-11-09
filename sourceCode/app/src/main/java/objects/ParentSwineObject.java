package objects;

import java.text.ParseException;
import java.util.Date;

import function.DateHanding;

/**
 * Created by vanthi on 11/1/2016.
 */

public class ParentSwineObject {
    /**
     *
     */
    private String ID;
    private Date dateImport;
    /**
     *
     */
    private String earNumber;

    /**
     *
     */
    private Date matingDate;

    /**
     *
     */
    private String coordinatorID;

    /**
     *
     */
    private Date expectedDateOfBirth;

    /**
     *
     */
    private Date realDateOfBirth;

    /**
     *
     */
    private int timesOfBirth;

    /**
     *
     */
    private int numberOfChilds;

    /**
     *
     */
    private String processID;

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    public ParentSwineObject(String ID, String earNumber, Date matingDate, String coordinatorID, Date expectedDateOfBirth, Date realDateOfBirth, int timesOfBirth, int numberOfChilds, String processID) {
        this.ID = ID;
        this.earNumber = earNumber;
        this.matingDate = matingDate;
        this.coordinatorID = coordinatorID;
        this.expectedDateOfBirth = expectedDateOfBirth;
        this.realDateOfBirth = realDateOfBirth;
        this.timesOfBirth = timesOfBirth;
        this.numberOfChilds = numberOfChilds;
        this.processID = processID;
    }

    public ParentSwineObject(String ID, String processID,String earNumber,Date dateImport) {
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

    public int getNumberOfChilds() {
        return numberOfChilds;
    }

    public void setNumberOfChilds(int numberOfChilds) {
        this.numberOfChilds = numberOfChilds;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }
}
