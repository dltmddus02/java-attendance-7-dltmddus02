package attendance.domain;

import static attendance.view.input.exception.InputErrorMessage.NOT_SCHOOL_DAY;

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

    public static void checkDay(int month, int day, String dayOfTheWeek) {
        if (day == 25) {
            String not_school_day = String.format(NOT_SCHOOL_DAY.getMessage(), month, day, dayOfTheWeek);
            throw new IllegalArgumentException(not_school_day);
//            System.out.printf("[ERROR] " + NOT_SCHOOL_DAY.getMessage(), month, day, dayOfTheWeek);
//            throw new InputException(InputErrorMessage.SPACE);
        }
        Calender calender = Arrays.stream(Calender.values())
                .filter(c -> c.days.contains(day))
                .filter(c -> c.dayOfTheWeek.equals(SAT.dayOfTheWeek) || c.dayOfTheWeek.equals(SUN.dayOfTheWeek))
                .findFirst()
                .orElse(null);

        if (calender != null) {
            String not_school_day = String.format(NOT_SCHOOL_DAY.getMessage(), month, day, dayOfTheWeek);
            throw new IllegalArgumentException(not_school_day);

//            System.out.printf("[ERROR] " + NOT_SCHOOL_DAY.getMessage(), month, day, dayOfTheWeek);
//            throw new InputException(InputErrorMessage.SPACE);
        }
    }
}
