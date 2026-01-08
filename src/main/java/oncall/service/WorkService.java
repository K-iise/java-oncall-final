package oncall.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oncall.model.Day;
import oncall.model.Holiday;
import oncall.model.Month;
import oncall.model.WorkInfo;
import oncall.model.WorkResult;
import oncall.model.WorkTemple;

public class WorkService {

    public WorkResult calculateWork(WorkInfo workInfo, WorkTemple workTemple){
        Month month = workInfo.getMonth();
        int startNumber = month.getStart();
        int endNumber = month.getEnd();
        String startDay = workInfo.getStartDay();


        Map<Integer, String> map = new LinkedHashMap<>();
        Day day = Day.fromDay(startDay);

        List<String> weekdayList = workTemple.getWeekdayTemple();
        int weekdayCount = 0;
        List<String> weekendList = workTemple.getWeekendTemple();
        int weekendCount = 0;


        for (int i = 0; i < endNumber; i++) {

            int date = i+1;
            int number = (day.getNumber() + i) % 7;

            Day dy = Day.fromNumber(number);
            String work = dy.getDay() + " ";

            if (checkHoliday(month.getMonth(), date)){
                work = dy.getDay() + "(휴일) ";
                work += weekendList.get(weekendCount++);
                map.put(date, work);
                weekendCount = weekendCount % weekendList.size();
                continue;
            }

            if (checkWeekend(number)) {
                work += weekendList.get(weekendCount++);
                map.put(date, work);
                weekendCount = weekendCount % weekendList.size();
                continue;
            }

            work += weekdayList.get(weekdayCount++);
            map.put(date, work);
            weekdayCount = weekdayCount % weekdayList.size();
        }

        return new WorkResult(month, map);
    }

    private boolean checkWeekend(int number) {
        return number == 5 || number == 6;
    }

    private boolean checkHoliday(int month, int day) {
        for (Holiday holiday : Holiday.values()) {
            if (holiday.getMonth() == month && holiday.getDay() == day){
                return true;
            }
        }
        return false;
    }
}
