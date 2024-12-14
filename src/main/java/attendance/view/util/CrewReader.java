package attendance.view.util;

import attendance.domain.Crew;
import attendance.domain.CrewRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CrewReader {
    private static final String ATTENDANCE_FILE_PATH = "src/main/resources/attendances.csv";
    private static final String FILE_LOAD_ERROR = "[ERROR] 크루원 목록을 불러오는 중 오류가 발생했습니다.";
    private final static String COMMA = ",";

    public static void storeCrew() {
        try (BufferedReader br = new BufferedReader(new FileReader(ATTENDANCE_FILE_PATH))) {
            readProductLines(br);
        } catch (IOException e) {
            System.err.println(FILE_LOAD_ERROR + ": " + e.getMessage());
        }
    }

    private static void readProductLines(BufferedReader br) throws IOException {
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            processEachProductLine(line);
        }
    }

    private static void processEachProductLine(String line) {
        parseLine(line);
    }

    private static void parseLine(String line) {
        String[] newLines = line.split(COMMA);
        String name = newLines[0];
        String dateTime = newLines[1];

//        크루 리포에 존재하는지 존재하면 추가
        Crew crew = CrewRepository.findCrewByName(name);

        crew.addDateTIme(dateTime);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDate date = LocalDate.parse()
        CrewRepository.addCrew(crew);
//        if (type.equals(Course.BACKEND.getName())) {
//            CrewRepository.addBackEndCrew(line);
//            return;
//        }
//        CrewRepository.addFrontEndCrew(line);
//
    }
}
