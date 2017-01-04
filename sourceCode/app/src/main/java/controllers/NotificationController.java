package controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;
import java.util.List;

import function.DateHanding;
import function.TextNotification;
import models.CardInfoModel;
import models.NotificationModel;
import objects.CardObject;
import objects.NotificationObject;

/**
 * Created by Van Thi on 1/1/2017.
 */

public class NotificationController extends AppCompatActivity{
    NotificationModel notificationModel;
    CardInfoModel cardInfoModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notificationModel = new NotificationModel(this);
        cardInfoModel = new CardInfoModel(this);
    }

    public void autoRemove(){
        Date date = DateHanding.getDateBefore(DateHanding.today(), 7);
        String daystr = DateHanding.getDateString(date);
        List<NotificationObject> lsNoti = notificationModel.search(daystr, 1);
        if (lsNoti != null) notificationModel.remove(lsNoti);
    }

}
