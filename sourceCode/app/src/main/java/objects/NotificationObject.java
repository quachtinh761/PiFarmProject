package objects;

import java.util.Date;


public class NotificationObject {

    private Date date;
    private String notification;

    public NotificationObject(Date date, String notification) {
        this.date = date;
        this.notification = notification;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
