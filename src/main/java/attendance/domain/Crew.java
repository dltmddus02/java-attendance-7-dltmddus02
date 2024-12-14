package attendance.domain;

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

    public List<String> getDateTIme() {
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
        System.out.println(beforeTime);

        String newTime = String.format("2024-12-%02d", day) + " " + time;
        System.out.println(newTime);
        dateTime.set(getIndex(day), newTime);
    }

    private int getIndex(int day) {
        return dateTime.stream()
                .filter(c -> c.contains(String.format("2024-12-%02d", day)))
                .map(c -> dateTime.indexOf(c))
                .findFirst()
                .orElse(-1);
    }
}
