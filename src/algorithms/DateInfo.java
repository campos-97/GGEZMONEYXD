package algorithms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInfo {

    private static DateFormat dateFormat;

    public static String getDate(){
        if(dateFormat == null){
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        }
        Date date = new Date();
        return dateFormat.format(date);
    }

}
