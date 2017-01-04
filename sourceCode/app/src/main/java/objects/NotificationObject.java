package objects;

import java.util.Date;


public class NotificationObject {
    /*
    *   1. Heo đẻ
    *   2. Vaccine heo mới nhập
    *   3. Chích thuốc heo mẹ mang thai
    *   4. Vaccine heo con
    *   5. Doi chuong
    *   6. Khác
     */
    private int type;
    private Date duedate;
    private String content;
    private boolean haveDone;
    private String CardID;

    public NotificationObject(int type, Date duedate, String content, boolean haveDone, String cardID) {
        this.type = type;
        this.duedate = duedate;
        this.content = content;
        this.haveDone = haveDone;
        CardID = cardID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHaveDone() {
        return haveDone;
    }

    public void setHaveDone(boolean haveDone) {
        this.haveDone = haveDone;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }
}
