package objects;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import function.DateHanding;
import function.IntergerHanding;
import function.StringHanding;

/**
 * Created by Van Thi on 12/29/2016.
 */

public class ChildObject {
    private String CardID;
    private Date dateOfBirthh, dateExport;
    private int totalSwineChild, totalDead;
    private List<String[]> History = new LinkedList<>(); //this array have 3 colum; 1.number Child dead, 2. date dead, 3.Cause Of Death

    //history is string type $aaDD-MM-YYYYCauseOfDeath#aaDD-MM-YYYYCauseOfDeath$
    public ChildObject(String cardID, Date dateOfBirthh, Date dateExport, int totalSwineChild, int totalDead, String History) {
        this.CardID = cardID;
        this.dateOfBirthh = dateOfBirthh;
        this.dateExport = dateExport;
        this.totalSwineChild = totalSwineChild;
        this.totalDead = totalDead;

        String[] temp = StringHanding.getArrayStr(History);
        String p[] = new String[3];
        for (int i = 0 ; i < temp.length; i++){
            //get collum
            p = new String[3];
            p[0] = temp[i].substring(0, 2);
            p[1] = temp[i].substring(2, 12);
            p[2] = temp[i].substring(12);

            //add to List
            this.History.add(p);
        }
    }

    public ChildObject(String cardID, Date dateOfBirthh, Date dateExport, int totalSwineChild, int totalDead, List<String[]> history) {
        this.CardID =cardID;
        this.dateOfBirthh = dateOfBirthh;
        this.dateExport = dateExport;
        this.totalSwineChild = totalSwineChild;
        this.totalDead = totalDead;
        History = history;
    }



    //return $aaDD-MM-YYYYCauseOfDeath#aaDD-MM-YYYYCauseOfDeath$
    public String getHistoryStr(){
        String temp[] = new String[History.size()];
        for (int i = 0; i < History.size(); i++){
            temp[i] = History.get(i)[0] + History.get(i)[1] + History.get(i)[2];
        }
        return StringHanding.getStr(temp);
    }

    public void addChildDead(int numberChildDie, Date dateDead, String CauseOfDeath){
        totalDead += numberChildDie;
        History.add(new String[]{numberChildDie + "", DateHanding.getDateString(dateDead), CauseOfDeath});
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public Date getDateOfBirthh() {
        return dateOfBirthh;
    }

    public void setDateOfBirthh(Date dateOfBirthh) {
        this.dateOfBirthh = dateOfBirthh;
    }

    public Date getDateExport() {
        return dateExport;
    }

    public void setDateExport(Date dateExport) {
        this.dateExport = dateExport;
    }

    public int getTotalSwineChild() {
        return totalSwineChild;
    }

    public void setTotalSwineChild(int totalSwineChild) {
        this.totalSwineChild = totalSwineChild;
    }

    public int getTotalDead() {
        return totalDead;
    }

    public void setTotalDead(int totalDead) {
        this.totalDead = totalDead;
    }

    public List<String[]> getHistory() {
        return History;
    }

    public void setHistory(List<String[]> history) {
        History = history;
    }
}
