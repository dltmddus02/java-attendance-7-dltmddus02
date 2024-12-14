package attendance.service;

import attendance.domain.AttendanceType;
import attendance.domain.Calender;
import attendance.domain.Crew;
import attendance.domain.CrewRepository;
import attendance.view.output.OutputView;

public class AttendanceModifyService {
    public void attendanceModify(String nickName, String dateToModify, String timeToModify) {
        Crew crew = CrewRepository.findCrewByName(nickName);

        int date = Integer.parseInt(dateToModify);
        crew.modifyAttendance(date, timeToModify);
    }

    public void recordAttendance(int todayDay, String name) {
        OutputView.printAttendanceRecord(name);

        int attendance = 0;
        int lateness = 0;
        int absence = 0;
        for (int currentDay = 1; currentDay <= todayDay; currentDay++) {
            if (Calender.isFreeDay(currentDay)) {
                continue;
            }
            String dayOfTheWeek = Calender.getDayOfTheWeekByDay(currentDay);
            String time = setTime(name, currentDay);
            String type = AttendanceType.getTypeByday(currentDay, time);

            if (type.equals(AttendanceType.ATTENDANCE.getType())) {
                attendance++;
            }
            if (type.equals(AttendanceType.LATENESS.getType())) {
                lateness++;
            }
            if (type.equals(AttendanceType.ABSENCE.getType())) {
                absence++;
            }

            OutputView.printAttendanceRecordDetail(currentDay, dayOfTheWeek, time, type);
        }
        OutputView.printAttendanceResult(attendance, lateness, absence);
        if (absence > 5) {
            System.out.println("제적 대상자입니다.");
        } else if (absence >= 3) {
            System.out.println("면담 대상자입니다.");
        } else if (absence >= 2) {
            System.out.println("경고 대상자입니다.");
        }

    }

    private String setTime(String name, int currentDay) {
        try {
            Crew crew = CrewRepository.findCrewByName(name);
            String dateTime = crew.getDateTime().get(currentDay);
            return dateTime.substring(11, 16);
        } catch (IndexOutOfBoundsException e) {
            return "--:--";
        }

    }
}
