package attendance.service;

import attendance.domain.Crew;
import attendance.domain.CrewRepository;

public class AttendanceModifyService {
    public void attendanceModify(String nickName, String dateToModify, String timeToModify) {
        Crew crew = CrewRepository.findCrewByName(nickName);

        int date = Integer.parseInt(dateToModify);
        crew.modifyAttendance(date, timeToModify);
    }
}
