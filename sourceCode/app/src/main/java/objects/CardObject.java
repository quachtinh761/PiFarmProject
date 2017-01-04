package objects;

import java.util.Date;
import function.DateHanding;
import function.IntergerHanding;
import function.StringHanding;

/**
 * Created by vanthi on 11/1/2016.
 */

public class CardObject {
    private String ID;
    private String FarmName;
    private Date dateImport;
    private String earNumber;
    private Date dateCoordination;
    private String coordinatorID;
    private int countBirths;
    private String History; //this is type aaaabbbbccccddddeeee with aaaa two first character is total child, two last is number child dead
    private String moreInfo;

    //create this object by string type $scsd#csdd#csdd#kjn$
    public CardObject(String dataInCard){
        String[] temp = StringHanding.getArrayStr(dataInCard);
        if (temp.length == 9){
            this.ID = temp[0];
            this.FarmName = temp[1];
            this.dateImport = DateHanding.getDate(temp[2]);
            this.earNumber = temp[3];
            this.dateCoordination = DateHanding.getDate(temp[4]);
            this.coordinatorID = temp[5];
            this.countBirths = IntergerHanding.getInterger(temp[6]);
            this.History = temp[7];
            this.moreInfo = temp[8];
        }
    }

    //this constructor for CardInfo in Database
    public CardObject(String ID, String earNumber, Date dateCoordination, Date dateImport){
        this.ID =  ID;
        this.earNumber = earNumber;
        this.dateCoordination = dateCoordination;
        this.dateImport = dateImport;
    }

    public CardObject(String ID, String farmName, Date dateImport, String earNumber, Date dateCoordination, String coordinatorID, int countBirths, String history, String moreInfo) {
        this.ID = ID;
        this.FarmName = farmName;
        this.dateImport = dateImport;
        this.earNumber = earNumber;
        this.dateCoordination = dateCoordination;
        this.coordinatorID = coordinatorID;
        this.countBirths = countBirths;
        this.History = history;
        this.moreInfo = moreInfo;
    }

    public String createData(){
        return FarmName + "#" + DateHanding.getDateString(dateImport) + "#" + earNumber + "#" +
                DateHanding.getDateString(dateCoordination) + "#" + coordinatorID + "#" +
                countBirths + "#" + History + "#" + moreInfo + "$";
    }

    public void addHistory(int totalChild, int totalChildDie){
        History += totalChild + "" + totalChildDie;
    }

    public int getCountBirths() {
        return countBirths;
    }

    public void setCountBirths(int countBirths) {
        this.countBirths = countBirths;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFarmName() {
        return FarmName;
    }

    public void setFarmName(String farmName) {
        FarmName = farmName;
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

    public String getHistory() {
        return History;
    }

    public void setHistory(String history) {
        History = history;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
