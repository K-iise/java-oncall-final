package oncall.service;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oncall.model.Day;
import oncall.model.Holiday;
import oncall.model.Month;
import oncall.model.Schedule;
import oncall.model.WorkInfo;
import oncall.model.WorkResult;
import oncall.model.WorkTemple;
import oncall.model.WorkerQueue;

public class WorkService {

    public WorkResult calculateWork(WorkInfo info, WorkTemple temple) {
        WorkerQueue weekdayQueue = new WorkerQueue(temple.getWeekdayTemple());
        WorkerQueue weekendQueue = new WorkerQueue(temple.getWeekendTemple());

        List<Schedule> result = new ArrayList<>();
        String lastWorker = "";

        for (int date = 1; date <= info.getMonth().getEnd(); date++) {
            Day day = info.getDayOfWeek(date);
            boolean isPublicHoliday = Holiday.isHoliday(info.getMonth(), date);
            boolean isWeekend = day.isWeekend();
            WorkerQueue targetQueue = (isPublicHoliday || isWeekend) ? weekendQueue : weekdayQueue;

            // 근무자 배정
            String worker = targetQueue.getNextWorker(lastWorker);

            // 결과 저장 (Schedule 객체 활용)
            result.add(new Schedule(date, day, isPublicHoliday, worker));
            lastWorker = worker;
        }
        return new WorkResult(info.getMonth(), result);
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
