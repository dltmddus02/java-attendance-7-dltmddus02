package attendance.view.output;

import static attendance.view.output.OutputMessage.INPUT_FEATURE;

public class OutputView {
    public static void printFeature(int month, int day) {
        System.out.printf(INPUT_FEATURE.getMessage(), month, day);
    }
}
