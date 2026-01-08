package oncall.model;

import java.util.Arrays;
import oncall.util.ErrorMessage;

public enum Month {
    JANUARY(1, 1, 31),
    FEBRUARY(2, 1, 28),
    MARCH(3, 1, 31),
    APRIL(4, 1, 30),
    MAY(5, 1, 31),
    JUNE(6, 1, 30),
    JULY(7, 1, 31),
    AUGUST(8, 1, 31),
    SEPTEMBER(9, 1, 30),
    OCTOBER(10, 1, 31),
    NOVEMBER(11, 1, 30),
    DECEMBER(12, 1, 31);

    Month(int month, int start, int end) {
        this.month = month;
        this.start = start;
        this.end = end;
    }

    private int month;
    private int start;
    private int end;

    public static Month from(int monthValue) {
        return Arrays.stream(Month.values()).filter(m -> m.month == monthValue)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WORKINFO_ERROR.getMessage()));
    }
}
