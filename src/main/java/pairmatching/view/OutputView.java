package pairmatching.view;

import java.util.List;

public class OutputView {
    public static final String PAIR_MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
    public static final String NO_EXIST_PAIR_MATCHING_RESULT_MESSAGE = "[ERROR] 매칭 이력이 없습니다.";
    public static final String PAIR_RECORD_INIT_MESSAGE = "초기화 되었습니다.";
    public void printPairMatchingResult(List<String> results) {
        System.out.println(PAIR_MATCHING_RESULT_MESSAGE);
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public void printPairMatchingFailMessage() {
        System.out.println(NO_EXIST_PAIR_MATCHING_RESULT_MESSAGE);
    }

    public void printPairRecordInitMessage() {
        System.out.println(PAIR_RECORD_INIT_MESSAGE);
    }
}