package competition_of_leecode;

import java.util.Calendar;

/**
 * @author liupeidong
 * Created on 2019/9/8 10:49
 */
public class dayOfTheWeek_5183 {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] strings = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return strings[(calendar.get(Calendar.DAY_OF_WEEK) - 1) % 7];
    }
}
