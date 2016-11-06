package objects;

import java.util.Date;

/**
 * Created by Guong on 11/6/2016.
 */

public class UserObject {
    private String id;
    private String password;
    private String first_name;
    private String last_name;
    private String birthday_string;
    private Date birthday_date;
    private String phone_number;
    private String right;

    public Date getBirthday_date() {
        return birthday_date;
    }

    public void setBirthday_date(Date birthday_date) {
        this.birthday_date = birthday_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthday_string() {
        return birthday_string;
    }

    public void setBirthday_string(String birthday_string) {
        this.birthday_string = birthday_string;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public boolean checkIsValidUser(){
        return true;
    }

}
