package attendance.view.output;

import static attendance.view.output.OutputMessage.ATTENDANCE;
import static attendance.view.output.OutputMessage.FINISH_MODIFY;
import static attendance.view.output.OutputMessage.INPUT_ATTENDANCE_TIME;
import static attendance.view.output.OutputMessage.INPUT_ATTENDANCE_TIME_TO_MODIFY;
import static attendance.view.output.OutputMessage.INPUT_DATE_TO_MODIFY;
import static attendance.view.output.OutputMessage.INPUT_FEATURE;
import static attendance.view.output.OutputMessage.INPUT_NICKNAME;

import attendance.domain.AttendanceType;

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
        String attendanceType = AttendanceType.getTypeByday(todayDay, attendanceTime);
//        System.out.println(attendanceType);
        System.out.printf(ATTENDANCE.getMessage(), todayMonth, todayDay, todayOfTheWeek, attendanceTime,
                attendanceType);
    }

    public static void printDateToModify() {
        System.out.println(INPUT_DATE_TO_MODIFY.getMessage());
    }

    public static void printAttendanceTimeToModify() {
        System.out.println(INPUT_ATTENDANCE_TIME_TO_MODIFY.getMessage());
    }

    public static void printFinishModify(int todayDay, String todayOfTheWeek) {
        System.out.println(FINISH_MODIFY.getMessage());
    }
}
