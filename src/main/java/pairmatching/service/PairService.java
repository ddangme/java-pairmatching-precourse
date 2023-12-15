package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constants.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.PairRecord;

import java.util.ArrayList;
import java.util.List;

public class PairService {

    private List<Crew> crews = new ArrayList<>();
    private List<PairRecord> pairRecords = new ArrayList<>();

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    public void generatePairCrew(PairRecord pairRecord) {
        pairRecords.add(pairRecord);
        generatePairRecord(pairRecord);
    }

    public void generatePairRecord(PairRecord pairRecord) {
        Course course = pairRecord.getCourse();
        List<String> crewsNameOfChoiceCourse = getCrewsNameOfChoiceCourse(course);
        addPairCrews(crewsNameOfChoiceCourse, pairRecord);
    }


    private List<String> getCrewsNameOfChoiceCourse(Course course) {
        List<String> crewNames = new ArrayList<>();

        for (Crew crew : crews) {
            if (crew.containInCourse(course)) {
                crewNames.add(crew.getName());
            }
        }

        return crewNames;
    }

    private void addPairCrews(List<String> crewNames, PairRecord pairRecord) {
        List<String> shuffleCrewNames = Randoms.shuffle(crewNames);

        while (shuffleCrewNames.size() != 0) {
            List<String> names = new ArrayList<>();
            addAndRemove(names, shuffleCrewNames);
            pairRecord.addPairCrews(names);
        }
    }

    private void addAndRemove(List<String> names, List<String> shuffleCreNames) {
        for (int count = 0; count < 2; count++) {
            names.add(shuffleCreNames.get(0));
            shuffleCreNames.remove(0);
        }
        if (shuffleCreNames.size() == 1) {
            names.add(shuffleCreNames.get(0));
            shuffleCreNames.remove(0);
        }
    }

    public PairRecord getSamePairRecord(PairRecord pairRecord) {
        for (PairRecord record : pairRecords) {
            if (record.isSameCourseAndLevel(pairRecord)) {
                return record;
            }
        }
        return null;
    }

    public void initPairRecords() {
        pairRecords = new ArrayList<>();
    }


}
