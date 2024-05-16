package domain.constants;

import java.time.DayOfWeek;
import java.util.*;

import static java.time.DayOfWeek.*;

public enum Week {
    WEEKDAYS(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY)),
    WEEKENDS(List.of(SATURDAY, FRIDAY));

    private final List<DayOfWeek> days;

    Week(List<DayOfWeek> days){
        this.days = days;
    }

    public static Week from(DayOfWeek dayOfWeek){

    }




}
