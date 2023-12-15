package pairmatching.domain;

import pairmatching.constants.Course;
import pairmatching.constants.ErrorMessage;
import pairmatching.constants.Level;

import java.util.ArrayList;
import java.util.List;

public class PairRecord {
    private Course course;
    private Level level;
    private String missionName;

    List<String> pairCrews = new ArrayList<>();

    public PairRecord(List<String> pairRecord) {
        validatePairRecordSize(pairRecord);
        this.course = Course.getCourse(pairRecord.get(0));
        this.level = Level.getLevel(pairRecord.get(1));
        level.matchLevelWithMission(pairRecord.get(2));
        this.missionName = pairRecord.get(2);
    }

    private void validatePairRecordSize(List<String> courseAndLevelAndMission) {
        if (courseAndLevelAndMission.size() < 3) {
            throw new IllegalArgumentException(ErrorMessage.COURSE_LEVEL_MISSION_REGEX_ERROR_MESSAGE);
        }
    }

    public Course getCourse() {
        return course;
    }

    public void addPairCrews(List<String> names) {
        pairCrews.add(String.join(" : ", names));
    }

}
