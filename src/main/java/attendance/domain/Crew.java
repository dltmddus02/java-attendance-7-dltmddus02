package attendance.domain;

import static attendance.view.output.OutputMessage.FINISH_MODIFY;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private final String name;
    private List<String> dateTime;

    public Crew(String name) {
        this.name = name;
        this.dateTime = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDateTime() {
        return dateTime;
    }

    public void addDateTIme(String dateTIme) {
        this.dateTime.add(dateTIme);
    }

    public boolean isExistName(String name) {
        return this.name.equals(name);
    }

    public void modifyAttendance(int day, String time) {
        String beforeTime = dateTime.stream()
                .filter(c -> c.contains(String.format("2024-12-%02d", day)))
                .findFirst()
                .orElse(null);
        beforeTime = beforeTime.substring(11, 16);

        dateTime.set(getIndex(day), time);

        String beforeAttendanceType = AttendanceType.getTypeByday(day, beforeTime);
        String newAttendanceType = AttendanceType.getTypeByday(day, time);

        System.out.printf(FINISH_MODIFY.getMessage(), day, Calender.getDayOfTheWeekByDay(day), beforeTime,
                beforeAttendanceType,
                time, newAttendanceType);
    }

    private int getIndex(int day) {
        return dateTime.stream()
                .filter(c -> c.contains(String.format("2024-12-%02d", day)))
                .map(c -> dateTime.indexOf(c))
                .findFirst()
                .orElse(-1);
    }
}
