package attendance.domain;

import java.util.Arrays;
import java.util.List;

public enum Calender {
    MON("월요일", List.of(2, 9, 16, 23, 30)),
    TUE("화요일", List.of(3, 10, 17, 24, 31)),
    WED("수요일", List.of(4, 11, 18, 25)),
    THU("목요일", List.of(5, 12, 19, 26)),
    FRI("금요일", List.of(6, 13, 20, 27)),
    SAT("토요일", List.of(7, 14, 21, 28)),
    SUN("일요일", List.of(1, 8, 15, 22, 29));

    final String dayOfTheWeek;
    final List<Integer> days;

    Calender(String dayOfTheWeek, List<Integer> days) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.days = days;
    }

    public static String getDayOfTheWeekByDay(int day) {
        return Arrays.stream(Calender.values())
                .filter(c -> c.days.contains(day))
                .map(c -> c.dayOfTheWeek)
                .findFirst()
                .orElse(null);
    }
}
