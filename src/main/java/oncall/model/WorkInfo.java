package oncall.model;

import java.util.List;

public class WorkInfo {
    private Month month;
    private String startDay;

    private WorkInfo(Month month, String startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public static WorkInfo FromList(String[] list) {
        Month monthEnum = Month.from(parseMonth(list[0]));
        validateStartDay(list[1]);
        return new WorkInfo(monthEnum, list[1]);
    }

    private static int parseMonth(String monthPart) {
        try {
            int monthParse = Integer.parseInt(monthPart.trim());
            return monthParse;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 월은 숫자여야 합니다.");
        }
    }
    private static void validateStartDay(String startDay) {
        List<String> day = List.of("월", "화", "수", "목", "금", "토", "일");
        if (!day.contains(startDay)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public Month getMonth() {
        return month;
    }

    public String getStartDay() {
        return startDay;
    }
}
