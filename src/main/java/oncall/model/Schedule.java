package oncall.model;

public class Schedule {
    private final int date;
    private final Day day;
    private final boolean isPublicHoliday;
    private final String workerName;

    public Schedule(int date, Day day, boolean isPublicHoliday, String workerName) {
        this.date = date;
        this.day = day;
        this.isPublicHoliday = isPublicHoliday;
        this.workerName = workerName;
    }

    public boolean isPublicHoliday() {
        return isPublicHoliday;
    }

    public int getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }

    public String getWorkerName() {
        return workerName;
    }
}
