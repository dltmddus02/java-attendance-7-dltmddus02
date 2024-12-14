package attendance.controller;

import attendance.domain.Calender;
import attendance.service.AttendanceModifyService;
import attendance.view.input.InputView;
import attendance.view.input.exception.InputException;
import attendance.view.output.OutputView;
import attendance.view.util.CrewReader;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;

public class AttendanceController {
    private AttendanceModifyService attendanceModifyService;
    int todayMonth;
    int todayDay;
    String todayOfTheWeek;

    public AttendanceController() {
        this.attendanceModifyService = new AttendanceModifyService();
    }

    public void run() {
        CrewReader.storeCrew();
        String feature = prepareFeature();

        if (feature.equals("1")) {
            attendanceCheck();
        }
        if (feature.equals("2")) {
            attendanceModification();
        }
        if (feature.equals("3")) {
            checkRecords();
        }
    }

    private String prepareFeature() {
        LocalDate today = DateTimes.now().toLocalDate();
        todayMonth = today.getMonthValue();
        todayDay = 13;
        todayOfTheWeek = "금요일";
//        todayDay = today.getDayOfMonth();
//        todayOfTheWeek = Calender.getDayOfTheWeekByDay(todayDay);

        try {
            OutputView.printFeature(todayMonth, todayDay, todayOfTheWeek);
            return InputView.inputFeature();
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    private void attendanceCheck() {
        Calender.checkDay(todayMonth, todayDay, todayOfTheWeek);
        try {
            OutputView.printNickName();
            String nickName = InputView.inputNickName();
            OutputView.printAttendanceTime();
            String attendanceTime = InputView.inputAttendanceTime();
            OutputView.printAttendance(todayMonth, todayDay, todayOfTheWeek, attendanceTime);
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
    }

    private void attendanceModification() {
        try {
            OutputView.printNickName();
            String nickName = InputView.inputNickName();
            OutputView.printDateToModify();
            String dateToModify = InputView.inputDateToModify();
            OutputView.printAttendanceTimeToModify();
            String timeToModify = InputView.inputAttendanceTime();

            attendanceModifyService.attendanceModify(nickName, dateToModify, timeToModify);
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkRecords() {
        try {
            OutputView.printNickName();
            String nickName = InputView.inputNickName();
            attendanceModifyService.recordAttendance(nickName);
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
    }
}
