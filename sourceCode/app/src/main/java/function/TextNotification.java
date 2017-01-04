package function;

import java.sql.DataTruncation;
import java.util.Date;

/**
 * Created by Van Thi on 12/30/2016.
 */

public class TextNotification {
    public static String swineImportVaccine(String earNumber, Date dateImport, int count, String vacineName){
        return "Làm Vaccine" + vacineName + " lần " + count + " cho heo có số tai " + earNumber + " ngày nhập " + DateHanding.getDateString(dateImport);
    }
    public static String swineBorn(String earnumber, Date dateBorn){
        return "Heo số tai" + earnumber + "đẻ dự kiến vào ngày" + DateHanding.getDateString(dateBorn);
    }
    public static String VaccineChild(String earnumber, String vaccineName){
        return "Làm Vaccine " + vaccineName + " cho heo con có số tai heo mẹ " + earnumber;
    }

}
