package attendance.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }


    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static void deleteCrew(String name) {
        crews.removeIf(crew -> Objects.equals(crew.getName(), name));
    }

    public static void deleteAll() {
        crews.clear();
    }

    public static Crew findCrewByName(String name) {
        return crews().stream()
                .filter(crew -> crew.isExistName(name))
                .findFirst()
                .orElse(new Crew(name));
    }


}
