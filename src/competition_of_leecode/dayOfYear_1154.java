package competition_of_leecode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author liupeidong
 * Created on 2019/8/12 8:37
 */
public class dayOfYear_1154 {

    public int dayOfYear(String date) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(simpleDateFormat.parse(date));
            return calendar.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
