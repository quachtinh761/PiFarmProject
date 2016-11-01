package objects;

import java.util.Date;

/**
 * Created by vanthi on 11/1/2016.
 */

public class ChildSwineObject {
    private String id;

    /**
     *
     */
    private String parentID;

    /**
     *
     */
    private String processID;

    /**
     *
     */
    private Date dateOfBirth;

    /**
     *
     */
    private int quantity;

    public ChildSwineObject(String id, String parentID, String processID, Date dateOfBirth, int quantity) {
        this.id = id;
        this.parentID = parentID;
        this.processID = processID;
        this.dateOfBirth = dateOfBirth;
        this.quantity = quantity;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
