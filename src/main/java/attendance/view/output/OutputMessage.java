package attendance.view.output;

public enum OutputMessage {
    INPUT_FEATURE("오늘은 %d월 %d일 %s입니다. 기능을 선택해 주세요.\n"
            + "1. 출석 확인\n"
            + "2. 출석 수정\n"
            + "3. 크루별 출석 기록 확인\n"
            + "4. 제적 위험자 확인\n"
            + "Q. 종료\n"),
    INPUT_NICKNAME("닉네임을 입력해 주세요.\n"),
    INPUT_ATTENDANCE_TIME("등교 시간을 입력해 주세요.\n"),
    INPUT_NICKNAME_TO_MODIFY("출석을 수정하려는 크루의 닉네임을 입력해 주세요.\n"),
    INPUT_DATE_TO_MODIFY("수정하려는 날짜(일)를 입력해 주세요.\n"),
    INPUT_ATTENDANCE_TIME_TO_MODIFY("언제로 변경하겠습니까?\n"),
    FINISH_MODIFY("%d월 ?근데 03으로 표시%d일 %s 10:07 (%s) -> 09:58 (%s) 수정 완료!\n"),
    ATTENDANCE_RECORD("%d월 %d일 %s 13:00 (%s)\n"),
    ATTENDANCE_RECORD_DETAIL("이번 달 %s의 출석 기록입니다.\n"),
    RISK_RESULT("제적 위험자 조회 결과\n"),
    RISK_RESULT_DETAIL("- %s: 결석 %d회, 지각 %d회 (%s)\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
