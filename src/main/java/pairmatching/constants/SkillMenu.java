package pairmatching.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SkillMenu {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_INQUIRY("2", "페어 조회"),
    PAIR_INIT("3", "페어 초기화"),
    PROGRAM_SHUT_DOWN("Q", "종료");

    private String code;
    private String skillName;

    SkillMenu(String code, String skillName) {
        this.code = code;
        this.skillName = skillName;
    }

    public static String MenuNameToString() {
        return Arrays.stream(SkillMenu.values())
                .map(skillMenu -> skillMenu.code + ". " + skillMenu.skillName)
                .collect(Collectors.joining("\n"));
    }

    public static SkillMenu getMenu(String menuName) {
        return Arrays.stream(SkillMenu.values())
                .filter(skill -> skill.code.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INPUT_SKILL_MENU_ERROR_MESSAGE));
    }
}
