package oncall.model;

import java.util.List;

public class WorkInfo {
    private Month month;
    private Day startDay;

    public WorkInfo(Month month, Day startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    // n일의 요일을 계산해서 반환하는 메서드
    public Day getDayOfWeek(int date) {
        // 1일이 시작 요일이므로, (date - 1)만큼 더해주면 해당 날짜의 요일 숫자가 나옵니다.
        int dayNumber = (startDay.getNumber() + (date - 1)) % 7;
        return Day.fromNumber(dayNumber);
    }

    public static WorkInfo FromList(String[] list) {
        Month monthEnum = Month.from(parseMonth(list[0]));
        validateStartDay(list[1]);
        Day dayEnum = Day.fromDay(list[1]);
        return new WorkInfo(monthEnum, dayEnum);
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

    public Day getStartDay() {
        return startDay;
    }
}
