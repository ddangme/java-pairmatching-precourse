package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String INPUT_SKILL_MENU_MESSAGE = "기능을 선택하세요.";
    private static final String SHARP = "#############################################";
    private static final String INPUT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
    private static final String INPUT_RE_MATCHING_CHOICE_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";


    public String inputSkillMenuMessage(String skillMenus) {
        System.out.println(INPUT_SKILL_MENU_MESSAGE);
        System.out.println(skillMenus);
        return Console.readLine().trim();
    }

    public String inputCourseAndLevelAndMission(String courses, List<String> missions) {
        System.out.println(SHARP);
        System.out.println("과정: " + courses);
        printLevelAndMission(missions);
        System.out.println(SHARP);
        System.out.println(INPUT_COURSE_LEVEL_MISSION_MESSAGE);
        return Console.readLine();
    }

    private void printLevelAndMission(List<String> missions) {
        System.out.println("미션:");
        for (String mission : missions) {
            System.out.println(" - " + mission);
        }
    }

    public String inputReMatchingChoiceMessage() {
        System.out.println(INPUT_RE_MATCHING_CHOICE_MESSAGE);
        return Console.readLine();
    }
}
