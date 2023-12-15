package pairmatching.view;

import java.util.List;

public class OutputView {
    public static final String PAIR_MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";

    public void printPairMatchingResult(List<String> results) {
        System.out.println(PAIR_MATCHING_RESULT_MESSAGE);
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }
}
