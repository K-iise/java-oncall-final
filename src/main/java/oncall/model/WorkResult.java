package oncall.model;

import java.util.List;
import java.util.Map;

public class WorkResult {
    private final Month month;
    private final Map<Integer, String> workSchedule;

    public WorkResult(Month month, Map<Integer, String> workSchedule) {
        this.month = month;
        this.workSchedule = workSchedule;
    }

    public Month getMonth() {
        return month;
    }

    public Map<Integer, String> getWorkSchedule() {
        return workSchedule;
    }
}
