package oncall.service;

import java.util.ArrayList;
import java.util.Collections;
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

            // 공휴일인지 검사
            if (checkHoliday(month.getMonth(), date)){
                work = dy.getDay() + "(휴일) ";

                // 만약에 이전 근무자가 연속될 시
                if (date-1 > 0 && map.get(date-1).contains(weekendList.get(weekendCount))){
                    // 스왑
                    Collections.swap(weekendList, weekendCount, weekendCount+1);
                }
                work += weekendList.get(weekendCount++);
                map.put(date, work);
                weekendCount = weekendCount % weekendList.size();
                continue;
            }

            // 주말인지 검사
            if (checkWeekend(number)) {

                // 만약에 이전 근무자가 연속될 시
                if (date-1 > 0 && map.get(date-1).contains(weekendList.get(weekendCount))){
                    // 스왑
                    Collections.swap(weekendList, weekendCount, weekendCount+1);
                }

                work += weekendList.get(weekendCount++);
                map.put(date, work);
                weekendCount = weekendCount % weekendList.size();
                continue;
            }

            // 만약에 이전 근무자가 연속될 시
            if (date -1 > 0 && map.get(date-1).contains(weekdayList.get(weekdayCount))){
                // 스왑
                Collections.swap(weekdayList, weekdayCount, weekdayCount+1);
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
