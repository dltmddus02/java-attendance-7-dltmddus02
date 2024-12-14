package attendance.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputFeature() {
        String feature = Console.readLine();
        InputValidator.validateFeature(feature);
        return feature;
    }

    public static String inputNickName() {
        String nickName = Console.readLine();
        InputValidator.validateNickName(nickName);
        return nickName;
    }

    public static String inputAttendanceTime() {
        String attendanceTime = Console.readLine();
        InputValidator.validateAttendanceTIme(attendanceTime);
        return attendanceTime;
    }

    public static String inputDateToModify() {
        String dateToModify = Console.readLine();
        InputValidator.validateDateToModify(dateToModify);
        return dateToModify;
    }
}
