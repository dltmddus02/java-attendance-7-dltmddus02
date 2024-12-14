package attendance.view.output;

import static attendance.view.output.OutputMessage.ATTENDANCE;
import static attendance.view.output.OutputMessage.INPUT_ATTENDANCE_TIME;
import static attendance.view.output.OutputMessage.INPUT_ATTENDANCE_TIME_TO_MODIFY;
import static attendance.view.output.OutputMessage.INPUT_DATE_TO_MODIFY;
import static attendance.view.output.OutputMessage.INPUT_FEATURE;
import static attendance.view.output.OutputMessage.INPUT_NICKNAME;

public class OutputView {
    public static void printFeature(int month, int day, String dayOfTheWeek) {
        System.out.printf(INPUT_FEATURE.getMessage(), month, day, dayOfTheWeek);
    }

    public static void printNickName() {
        System.out.println(INPUT_NICKNAME.getMessage());
    }

    public static void printAttendanceTime() {
        System.out.println(INPUT_ATTENDANCE_TIME.getMessage());
    }

    public static void printAttendance(int todayMonth, int todayDay, String todayOfTheWeek, String attendanceTime) {
        System.out.printf(ATTENDANCE.getMessage(), todayMonth, todayDay, todayOfTheWeek, attendanceTime, "출석");
    }

    public static void printDateToModify() {
        System.out.println(INPUT_DATE_TO_MODIFY.getMessage());
    }

    public static void printAttendanceTimeToModify() {
        System.out.println(INPUT_ATTENDANCE_TIME_TO_MODIFY.getMessage());
    }
}
