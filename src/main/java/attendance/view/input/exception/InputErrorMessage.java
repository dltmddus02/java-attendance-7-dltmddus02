package attendance.view.input.exception;

public enum InputErrorMessage {
    //    INVALID_INPUT("잘못된 형식을 입력하였습니다.\n"),
    INCORRECT_INPUT_FORMAT("잘못된 형식을 입력하였습니다.\n"),
    NOT_REGISTER_NICKNAME("등록되지 않은 닉네임입니다.\n"),
    NOT_SCHOOL_DAY("%d월 %d일 %s은 등교일이 아닙니다.\n"),
    POSITIVE_NUMBER_REQUIRED("양수만 입력 가능합니다.\n");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    InputErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
