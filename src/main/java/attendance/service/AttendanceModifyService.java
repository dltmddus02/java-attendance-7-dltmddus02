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
        Crew crew = CrewRepository.findCrewByName(name);
        OutputView.printAttendanceRecord(name);

        for (int currentDay = 1; currentDay <= todayDay; currentDay++) {
            if (Calender.isFreeDay(currentDay)) {
                continue;
            }
            String dayOfTheWeek = Calender.getDayOfTheWeekByDay(currentDay);
            String time = setTime(name, currentDay);
            String type = AttendanceType.getTypeByday(currentDay, time);

            OutputView.printAttendanceRecordDetail(currentDay, dayOfTheWeek, time, type);
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
