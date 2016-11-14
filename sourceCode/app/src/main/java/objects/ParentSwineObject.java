package objects;

import java.text.ParseException;
import java.util.Date;

import function.DateHanding;

/**
 * Created by vanthi on 11/1/2016.
 */

public class ParentSwineObject {

    private String ID;  // earnumber + "-" + DateImport
    private Date dateImport;
    private String earNumber;
    private Date dateCoordination;
    private String coordinatorID;
    private Date expectedDateOfBirth;
    private String IDprocess;
    private String process; //chua du lieu process da tinh toan dang $$
    private String lsChildID; //chua list id theo dang $#$
    private String  note; //chua note nguoi dung


    public String getNote() {
        return note;
    }

    public ParentSwineObject(String ID, Date dateImport, String earNumber, Date dateCoordination, String coordinatorID, Date expectedDateOfBirth, String IDprocess, String process, String lsChildID, String note) {
        this.ID = ID;
        this.dateImport = dateImport;
        this.earNumber = earNumber;
        this.dateCoordination = dateCoordination;
        this.coordinatorID = coordinatorID;
        this.expectedDateOfBirth = expectedDateOfBirth;
        this.IDprocess = IDprocess;
        this.process = process;
        this.lsChildID = lsChildID;
        this.note = note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Date getDateCoordination() {
        return dateCoordination;
    }

    public void setDateCoordination(Date dateCoordination) {
        this.dateCoordination = dateCoordination;
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

    public String getIDprocess() {
        return IDprocess;
    }

    public void setIDprocess(String IDprocess) {
        this.IDprocess = IDprocess;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getLsChildID() {
        return lsChildID;
    }

    public void setLsChildID(String lsChildID) {
        this.lsChildID = lsChildID;
    }
}