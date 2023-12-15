package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_SKILL_MENU_MESSAGE = "기능을 선택하세요.";

    public String inputSkillMenuMessage(String skillMenus) {
        System.out.println(INPUT_SKILL_MENU_MESSAGE);
        System.out.println(skillMenus);
        return Console.readLine().trim();
    }
}
