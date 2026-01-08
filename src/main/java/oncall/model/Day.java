package oncall.model;

public enum Day {
    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final String day;
    private final int number;

    Day(String day, int number) {
        this.day = day;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDay() {
        return day;
    }

    public static Day fromDay(String input){
        for (Day day : Day.values()){
            if (day.day.equals(input)){
                return day;
            }
        }
        throw new IllegalArgumentException("[ERROR] 요일은 월~일만 입력해주세요.");
    }

    public static Day fromNumber(int number) {
        for (Day day : Day.values()) {
            if (day.number == number){
                return day;
            }
        }
        throw new IllegalArgumentException("[ERROR] 요일 숫자는 0 ~ 6입니다.");
    }
}
