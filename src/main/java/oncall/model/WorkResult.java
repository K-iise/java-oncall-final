package oncall.model;

import java.util.List;
import java.util.Map;

public class WorkResult {
    private final Month month;
    private final List<Schedule> schedules;
    public WorkResult(Month month, List<Schedule> schedules) {
        this.month = month;
        this.schedules = schedules;
    }

    public Month getMonth() { return month; }
    public List<Schedule> getSchedules() { return schedules; }
}
