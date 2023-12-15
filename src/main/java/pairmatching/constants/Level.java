package pairmatching.constants;

import java.util.ArrayList;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주, 로또, 숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", new ArrayList<>());

    private String levelName;
    private List<String> missions;

    Level(String levelName, List<String> missions) {
        this.levelName = levelName;
        this.missions = missions;
    }

}