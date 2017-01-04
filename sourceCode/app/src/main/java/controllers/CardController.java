package controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import function.DateHanding;
import function.IntergerHanding;
import function.PostMethod;
import function.StringHanding;
import objects.CardObject;

/**
 * Created by Van Thi on 12/31/2016.
 */

public class CardController extends AppCompatActivity{
    private static String keyA = "ABCDEFGH";
    public static String keyB = "";
    private static String urlRead = "urlRead",
            urlWrite = "urlWrite";
    PostMethod readCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        readCard = new PostMethod(urlRead, keyA, "", "");
    }

    public void setKeyB(String keyB){
        this.keyB = keyB;
    }

    public String getIDCard(){
        String result = readCard.send();
        String[] p = StringHanding.getArrayStr(result);
        if (p == null) return "";
        else return p[0];
    }
    /*
    *   Data in String[] will return
    *   1. Date Import
    *   2. Thoi gian da mang thai (ngay)
    *   3. Thoi gian con lai (ngay)
    *   4.Ngay de du kien
     */
    public String[] getNecessInfoInCard(){
        String[] temp = StringHanding.getArrayStr(readCard.send());
        if (temp != null) {
            String[] ret = new String[4];
            ret[0] = temp[1];
            ret[1] = DateHanding.dayDistance(DateHanding.getDate(ret[0]), DateHanding.today()) + "";
            ret[2] = (115 - IntergerHanding.getInterger(ret[1])) + "";
            ret[3] = DateHanding.getDateString(DateHanding.getDateAfter(DateHanding.getDate(ret[0]), 115));
            return ret;
        }
        return null;
    }
    public String[] getAllInfo(){
        return StringHanding.getArrayStr(readCard.send());
    }
    public boolean writeCard(CardObject object){
        PostMethod wr = new PostMethod(urlWrite, keyB, object.getID(), object.createData());
        if( wr.send().equals("Sucess")) return true;
        return false;
    }
    //read data card and return object
    public CardObject getObject(){
        return new CardObject(readCard.send());
    }
    //dataToUpdate if which field don't update we must set it null(date), ""(string), 0(int)
    public boolean updateCard(CardObject dataToUpdate){
        CardObject temp = new CardObject(readCard.send());
        if (dataToUpdate.getID().equals(temp.getID())){
            if (dataToUpdate.getCountBirths() != 0) temp.setCountBirths(dataToUpdate.getCountBirths());
            if(!dataToUpdate.getCoordinatorID().equals("")) temp.setCoordinatorID(dataToUpdate.getCoordinatorID());
            if (!dataToUpdate.getEarNumber().equals("")) temp.setEarNumber(dataToUpdate.getEarNumber());
            if(dataToUpdate.getDateCoordination() != null) temp.setDateCoordination(dataToUpdate.getDateCoordination());
            if(dataToUpdate.getDateImport() != null) temp.setDateImport(dataToUpdate.getDateImport());
            if(!dataToUpdate.getFarmName().equals("")) temp.setFarmName(dataToUpdate.getFarmName());
            if(!dataToUpdate.getHistory().equals("")) temp.setHistory(dataToUpdate.getHistory());
            if(!dataToUpdate.getMoreInfo().equals("")) temp.setMoreInfo(dataToUpdate.getMoreInfo());

            writeCard(temp);
            return true;
        }
        else return false;
    }
    public boolean resetCard(String IDCard){
        PostMethod reset = new PostMethod(urlWrite, keyB, IDCard, "");
        if (reset.send().equals("Sucess")){
            return true;
        }
        else return false;
    }
}
