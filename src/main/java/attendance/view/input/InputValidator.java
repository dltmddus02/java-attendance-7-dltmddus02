package attendance.view.input;

import attendance.domain.CrewRepository;
import attendance.view.input.exception.InputErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {
    private final static String COMMA = ",";

    public static void validateFeature(String input) {
        validateNotNullOrEmpty(input);
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals(
                "Q")) {
            throw new IllegalArgumentException(InputErrorMessage.INCORRECT_INPUT_FORMAT.getMessage());
        }
    }

    public static void validateNickName(String input) {
        validateNotNullOrEmpty(input);
        if (!CrewRepository.isExistCrew(input)) {
            throw new IllegalArgumentException(InputErrorMessage.NOT_REGISTER_NICKNAME.getMessage());
        }
    }

    public static void validateAttendanceTIme(String input) {
        validateNotNullOrEmpty(input);
        if (!isCorrectFormat(input)) {
            throw new IllegalArgumentException(InputErrorMessage.INCORRECT_INPUT_FORMAT.getMessage());
        }
    }

    public static void validateDateToModify(String input) {
        validateNotNullOrEmpty(input);
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.INCORRECT_INPUT_FORMAT.getMessage());
        }
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 31) {
            throw new IllegalArgumentException(InputErrorMessage.INCORRECT_INPUT_FORMAT.getMessage());
        }
    }

    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(InputErrorMessage.INCORRECT_INPUT_FORMAT.getMessage());
        }
    }

    // 양수만 입력 가능한 경우
//    public static void validatePositiveInteger(String input) {
//        try {
//            Integer.parseInt(input);
//        } catch (NumberFormatException e) {
//            throw new InputException(InputErrorMessage.INTEGER_REQUIRED);
//        }
//        if (Integer.parseInt(input) < 0) {
//            throw new InputException(InputErrorMessage.POSITIVE_NUMBER_REQUIRED);
//        }
//    }
//
//    // 패턴 이용해야 할 때
//    public static void validateFormat(String input) {
//        if (!isCorrectFormat(input)) {
//            throw new InputException(InputErrorMessage.INVALID_INPUT);
//        }
//    }

    private static boolean isCorrectFormat(String input) {
        String characterPattern = "[가-힣]+";
        String numberPattern = "[0-9]+";

        String datePattern = "2[0-3]|[01][0-9]:[0-5][0-9]";
//        String singlePattern = String.format("\\[(%s),(%s)]", characterPattern, numberPattern);
//        String repeatPattern = String.format("%s(;%s)*", singlePattern, singlePattern);

        Pattern correctPattern = Pattern.compile(datePattern);

        return correctPattern.matcher(input).find();
    }
}
