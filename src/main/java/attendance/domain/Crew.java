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
}
