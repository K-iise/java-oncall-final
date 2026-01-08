package oncall.view;

import java.util.List;
import java.util.Map;
import oncall.model.Month;
import oncall.model.Schedule;
import oncall.model.WorkResult;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWorkResult(WorkResult workResult) {
        List<Schedule> schedules = workResult.getSchedules();
        Month month = workResult.getMonth();

        System.out.println();
        for (Schedule schedule : schedules) {
            // 공휴일 여부에 따라 (휴일) 텍스트 추가
            String holidaySuffix = schedule.isPublicHoliday() ? "(휴일)" : "";

            System.out.printf("%d월 %d일 %s%s %s%n",
                    month.getMonth(),
                    schedule.getDate(),
                    schedule.getDay().getDay(), // Day Enum에서 "월", "화" 등을 가져옴
                    holidaySuffix,
                    schedule.getWorkerName()
            );
        }
    }
}
