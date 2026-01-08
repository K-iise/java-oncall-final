package oncall.model;

public enum Holiday {
    NEW_YEAR_DAY(1, 1),
    INDEPENDENCE_DAY(3, 1),
    CHILDREN_DAY(5,5),
    MEMORIAL_DAY(6,6),
    LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS_DAY(12, 5);

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static boolean isHoliday(Month month, int date) {
        for (Holiday holiday : Holiday.values()) {
            if (month.getMonth() == holiday.getMonth() && holiday.getDay() == date) {
                return true;
            }
        }
        return false;
    }
}
