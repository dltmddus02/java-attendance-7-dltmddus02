package attendance.domain;

import static attendance.view.input.exception.InputErrorMessage.NOT_OPERATING_HOURS;

import java.time.LocalTime;

public enum AttendanceType {
    ATTENDANCE("출석"),
    LATENESS("지각"),
    ABSENCE("결석");

    final String type;

    AttendanceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    //    시간에 따라 리턴하는 함수
    public static String getTypeByday(int day, String attendanceTime) {
        String dayOfTheWeek = Calender.getDayOfTheWeekByDay(day);
        if (attendanceTime.equals("--:--")) {
            return AttendanceType.ABSENCE.getType();
        }

        int hour = Integer.parseInt(attendanceTime.substring(0, 2));
        int minute = Integer.parseInt(attendanceTime.substring(3, 5));
        LocalTime localTime = LocalTime.of(hour, minute);

        validateAttendanceTime(dayOfTheWeek, localTime);

        if (dayOfTheWeek.equals(Calender.MON.dayOfTheWeek)) {
            if (localTime.isAfter(LocalTime.of(13, 30))) {
                return AttendanceType.ABSENCE.getType();
            }
            if (localTime.isAfter(LocalTime.of(13, 5))) {
                return AttendanceType.LATENESS.getType();
            }
            return AttendanceType.ATTENDANCE.getType();
        } else if (dayOfTheWeek.equals(Calender.TUE.dayOfTheWeek) || dayOfTheWeek.equals(Calender.WED.dayOfTheWeek)
                || dayOfTheWeek.equals(Calender.THU.dayOfTheWeek) || dayOfTheWeek.equals(Calender.FRI.dayOfTheWeek)) {
            if (localTime.isAfter(LocalTime.of(10, 30))) {
                return AttendanceType.ABSENCE.getType();
            }
            if (localTime.isAfter(LocalTime.of(10, 5))) {
                return AttendanceType.LATENESS.getType();
            }
        }
        return AttendanceType.ATTENDANCE.getType();
    }

    private static void validateAttendanceTime(String dayOfTheWeek, LocalTime localTime) {
        boolean isValidAttendanceTime = false;
//        if (dayOfTheWeek.equals(Calender.MON.dayOfTheWeek)) {
        isValidAttendanceTime = localTime.isAfter(LocalTime.of(7, 59)) && localTime.isBefore(LocalTime.of(23, 1));
//        } else if (dayOfTheWeek.equals(Calender.TUE.dayOfTheWeek) || dayOfTheWeek.equals(Calender.WED.dayOfTheWeek)
//                || dayOfTheWeek.equals(Calender.THU.dayOfTheWeek) || dayOfTheWeek.equals(Calender.FRI.dayOfTheWeek)) {
//            isValidAttendanceTime = localTime.isAfter(LocalTime.of(10, 0)) && localTime.isBefore(LocalTime.of(10, 0));
//        }
        if (!isValidAttendanceTime) {
            throw new IllegalArgumentException(NOT_OPERATING_HOURS.getMessage());
        }
    }
}
