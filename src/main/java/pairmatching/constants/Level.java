package pairmatching.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", new ArrayList<>());

    private String step;
    private List<String> missions;

    Level(String step, List<String> missions) {
        this.step = step;
        this.missions = missions;
    }

    public static List<String> levelAndMissionToString() {
        return Arrays.stream(Level.values())
                .map(level -> level.step + ": " + String.join(" | ", level.missions))
                .collect(Collectors.toList());
    }

    public static Level getLevel(String levelName) {
        return Arrays.stream(Level.values())
                .filter(level -> level.step.equals(levelName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.LEVEL_TYPE_ERROR_MESSAGE));
    }

    public void matchLevelWithMission(String missionName) {
        if (!this.missions.contains(missionName)) {
            throw new IllegalArgumentException(ErrorMessage.MISSION_TYPE_ERROR_MESSAGE);
        }
    }
}