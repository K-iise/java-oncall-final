package oncall.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.util.ErrorMessage;

public class WorkTemple {
    private final List<String> weekdayTemple;
    private final List<String> weekendTemple;

    public WorkTemple(List<String> weekdayTemple, List<String> weekendTemple) {
        validateAll(weekdayTemple);
        validateAll(weekendTemple);
        this.weekdayTemple = weekdayTemple;
        this.weekendTemple = weekendTemple;
    }

    public static WorkTemple FromList(List<String> weekdayTemple, List<String> weekendTemple) {
        return new WorkTemple(weekdayTemple, weekendTemple);
    }

    private void validateAll(List<String> crewList) {
        validateLength(crewList);
        validateRange(crewList);
        validateDuplication(crewList);
    }

    private void validateLength(List<String> crewList) {
        for (String name : crewList) {
            if (name == null || name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
            }
        }
    }

    private void validateDuplication(List<String> crewList) {
        Set<String> fake = new HashSet<>(crewList);
        if (crewList.size() != fake.size()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    public void validateRange(List<String> crewList) {
        int crewCount = crewList.size();
        if (!(crewCount >= 5 && crewCount <= 35)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getMessage());
        }
    }

    public List<String> getWeekdayTemple() {
        return weekdayTemple;
    }

    public List<String> getWeekendTemple() {
        return weekendTemple;
    }
}
