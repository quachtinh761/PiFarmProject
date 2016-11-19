package objects;

import java.util.Date;

/**
 * Created by vanthi on 11/1/2016.
 */

public class ChildSwineObject {
    private String id;  // = IDParent + BirthDay
    private String parentID;
    private String processID;
    private String process;
    private Date dateOfBirth;
    private int total;
    private String childDie; //include number#nguyen nhan
    private int numberChildDie;

    public ChildSwineObject(String id, String parentID, String processID, String process, Date dateOfBirth, int total, String childDie, int numberChildDie) {
        this.id = id;
        this.parentID = parentID;
        this.processID = processID;
        this.process = process;
        this.dateOfBirth = dateOfBirth;
        this.total = total;
        this.childDie = childDie;
        this.numberChildDie = numberChildDie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getChildDie() {
        return childDie;
    }

    public void setChildDie(String childDie) {
        this.childDie = childDie;
    }

    public int getNumberChildDie() {
        return numberChildDie;
    }

    public void setNumberChildDie(int numberChildDie) {
        this.numberChildDie = numberChildDie;
    }
}