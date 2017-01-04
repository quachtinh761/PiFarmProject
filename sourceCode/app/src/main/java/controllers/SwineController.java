package controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import function.DateHanding;
import function.IntergerHanding;
import function.PostMethod;
import function.StringHanding;
import function.TextNotification;
import models.CardInfoModel;
import models.ChildModel;
import models.NotificationModel;
import models.VaccineModel;
import objects.CardObject;
import objects.ChildObject;
import objects.NotificationObject;
import objects.ProcessObject;
import objects.VaccineObject;

/**
 * Created by Van Thi on 12/30/2016.
 */

public class SwineController extends AppCompatActivity {
    private CardInfoModel cardInfoModel;
    private VaccineModel vaccineModel;
    private NotificationModel notificationModel;
    private CardController cardController;
    private ChildModel childModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set content
        //setContentView();

        cardInfoModel = new CardInfoModel(this);
        vaccineModel = new VaccineModel(this);
        notificationModel = new NotificationModel(this);
        cardController = new CardController();
        childModel = new ChildModel(this);
    }

    //set keyB to write Card
    public void setKeyB(String keyB){
        cardController.setKeyB(keyB);
    }

    /* type Notification
    *   1. Heo đẻ
    *   2. Vaccine heo mới nhập
    *   3. Chích thuốc heo mẹ mang thai
    *   4. Vaccine heo con
    *   5. Khác
     */

    public boolean addSwine(ProcessObject processObject, String farmName, Date dateImport, String earNumber, String moreInfo){
        //read Card to get card ID
        String ID = cardController.getIDCard();
        if (ID.equals("")) return false;

        //create CardObject
        CardObject cardObject = new CardObject(ID, farmName, dateImport, earNumber, null, "", 0, "", moreInfo);
       //get value to create Notification
        List<VaccineObject> lsSearch;
        List<NotificationObject> lsNoti = new LinkedList<>();
        for (int i = 0; i < processObject.getLsVaccineID().size(); i++){
            Date date = new Date();
            int dose = 0;

            if (i == 0){
                lsSearch = vaccineModel.search(processObject.getLsVaccineID().get(i));
                if (lsSearch != null && lsSearch.size() != 0 && lsSearch.size() == 1){
                    date = DateHanding.getDateAfter(dateImport, processObject.getnDay());
                    dose = IntergerHanding.getInterger(lsSearch.get(0).getDose());
                    lsNoti.add(new NotificationObject(2, date, TextNotification.swineImportVaccine(earNumber, dateImport, i+1,lsSearch.get(0).getName()), false, ID));
                }
            }
            else {
                date = DateHanding.getDateAfter(date, dose);
                lsSearch = vaccineModel.search(processObject.getLsVaccineID().get(i));
                if (lsSearch != null && lsSearch.size() != 0 && lsSearch.size() == 1){
                    dose = IntergerHanding.getInterger(lsSearch.get(0).getDose());
                    lsNoti.add(new NotificationObject(2, date, TextNotification.swineImportVaccine(earNumber, dateImport, i+1,lsSearch.get(0).getName()), false, ID));
                }
            }
        }
        notificationModel.add(lsNoti);
        cardInfoModel.add(cardObject);

        //writeCard
        if (cardController.writeCard(cardObject)){
            return true;
        }
        else {
            notificationModel.remove(lsNoti);
            cardInfoModel.remove(cardObject);
            return false;
        }

    }
    //date import can null
    public boolean removeSwine(String earnumber, Date dateImport){
        if (earnumber.equals("")) return false;
        else {
            List<NotificationObject> lsNoti;
            List<CardObject> lsCard;
            if (dateImport == null){
                lsNoti = notificationModel.search(earnumber);
                lsCard = cardInfoModel.search(earnumber);
            }
            else {
                lsNoti = notificationModel.search(new String[]{earnumber, DateHanding.getDateString(dateImport)});
                lsCard = cardInfoModel.search(new String[]{earnumber, DateHanding.getDateString(dateImport)});
            }
            if (cardController.resetCard(lsCard.get(0).getID())) {
                notificationModel.remove(lsNoti);
                cardInfoModel.remove(lsCard);
                return true;
            }
            else return false;
        }
    }
    public boolean farrow(ProcessObject childProcess,Date dateFarrow,int totalChild, int numberChildDie, String CauseOfDeath){
        //read card get object;
        CardObject object = cardController.getObject();
        String IDCard = object.getID();

        List<CardObject> cardObjects = cardInfoModel.search(IDCard, 0);
        if (cardObjects == null) return false;


        //update for card
        object.addHistory(totalChild, numberChildDie);
        //update for CHilde (save in DB)
        ChildObject childObject;
        if (numberChildDie == 0) {
            childObject = new ChildObject(IDCard, dateFarrow, null, totalChild, numberChildDie, new LinkedList<String[]>());
        }
        else {
            childObject = new ChildObject(IDCard, dateFarrow, null, totalChild, numberChildDie, "$" + numberChildDie + DateHanding.getDateString(dateFarrow) + CauseOfDeath);
        }

        //write Card update History
        if (cardController.writeCard(object)){
            childModel.add(childObject);
            //Add Notification
            List<VaccineObject> lsSearch;
            List<NotificationObject> lsNoti = new LinkedList<>();
            for (int i = 0; i < childProcess.getLsVaccineID().size(); i++){
                Date date = new Date();
                int dose = 0;

                if (i == 0){
                    lsSearch = vaccineModel.search(childProcess.getLsVaccineID().get(i));
                    if (lsSearch != null && lsSearch.size() != 0 && lsSearch.size() == 1){
                        date = DateHanding.getDateAfter(dateFarrow, childProcess.getnDay());
                        dose = IntergerHanding.getInterger(lsSearch.get(0).getDose());
                        lsNoti.add(new NotificationObject(2, date, TextNotification.VaccineChild(object.getEarNumber(), lsSearch.get(i).getName()), false, IDCard));
                    }
                }
                else {
                    date = DateHanding.getDateAfter(date, dose);
                    lsSearch = vaccineModel.search(childProcess.getLsVaccineID().get(i));
                    if (lsSearch != null && lsSearch.size() != 0 && lsSearch.size() == 1){
                        dose = IntergerHanding.getInterger(lsSearch.get(0).getDose());
                        lsNoti.add(new NotificationObject(2, date, TextNotification.VaccineChild(object.getEarNumber(), lsSearch.get(i).getName()), false, IDCard));
                    }
                }
            }
            notificationModel.add(lsNoti);
        }
        return true;
    }
    public boolean childDie(String IDCard, String userID, int nuberChildDIe, String CauseOfDeath, Date dateDie){
        List<ChildObject> lsChild = childModel.search(IDCard, 0);
        if (lsChild == null || lsChild.size() > 1) return false;
        else {
            if (lsChild.get(0).getTotalDead() + nuberChildDIe > lsChild.get(0).getTotalSwineChild()) return false;

            lsChild.get(0).addChildDead(nuberChildDIe, dateDie, CauseOfDeath);

            childModel.update(lsChild.get(0));

            return true;
        }
    }

    public boolean addNoteInSwine(String note){
        CardObject cardObject = cardController.getObject();
        if (cardObject == null) return false;
        cardObject.setMoreInfo(cardObject.getMoreInfo() + ", " + note);

        if (cardController.writeCard(cardObject)) return true;
        return false;
    }
}
