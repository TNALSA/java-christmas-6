package domain.constants;

import java.time.DayOfWeek;
import java.util.*;

import static java.time.DayOfWeek.*;

public enum WeekInfo {
    WEEKDAYS(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY)),
    WEEKENDS(List.of(SATURDAY, FRIDAY));

    private final List<DayOfWeek> days;

    WeekInfo(List<DayOfWeek> days){
        this.days = days;
    }
    public static WeekInfo from(DayOfWeek dayOfWeek){
        return Arrays.stream(WeekInfo.values())
                .filter(element -> element.days.contains(dayOfWeek))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }
}
