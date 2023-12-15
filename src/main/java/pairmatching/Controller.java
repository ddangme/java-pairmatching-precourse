package pairmatching;

import pairmatching.constants.Course;
import pairmatching.constants.Level;
import pairmatching.constants.SkillMenu;
import pairmatching.domain.Crew;
import pairmatching.domain.PairRecord;
import pairmatching.service.GenerateCrewService;
import pairmatching.service.PairService;
import pairmatching.utils.ParseUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    PairService pairService = new PairService();

    public void run() {
        setCrews();

        boolean programRun = true;
        while (programRun) {
            SkillMenu skillMenu = menuChoice();
            programRun = runSkill(skillMenu);
        }
    }

    private void setCrews() {
        GenerateCrewService generateCrewService = new GenerateCrewService();
        List<Crew> crews = generateCrewService.generateCrews();

        pairService.setCrews(crews);
    }

    private SkillMenu menuChoice() {
        while (true) {
            try {
                String inputMenu = inputView.inputSkillMenuMessage(SkillMenu.MenuNameToString());
                return SkillMenu.getMenu(inputMenu);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean runSkill(SkillMenu skillMenu) {
        if (skillMenu.equals(SkillMenu.PAIR_MATCHING)) {
            PairRecord pairRecord = getCourseAndLevelAndMission();
            pairService.generatePairCrew(pairRecord);
            outputView.printPairMatchingResult(pairRecord.pairCrewToString());
            return true;
        }
        if (skillMenu.equals(SkillMenu.PAIR_INQUIRY)) {
            PairRecord pairRecord = getCourseAndLevelAndMission();
            PairRecord getPairRecord = pairService.getSamePairRecord(pairRecord);
            if (getPairRecord != null) {
                outputView.printPairMatchingResult(getPairRecord.pairCrewToString());
                return true;
            }
            outputView.printPairMatchingFailMessage();
            return true;
        }
        if (skillMenu.equals(SkillMenu.PAIR_INIT)) {
            pairService.initPairRecords();
            return true;
        }
        return false;
    }

    private PairRecord getCourseAndLevelAndMission() {
        while (true) {
            try {
                String inputCourseAndLevelAndMission = inputView.inputCourseAndLevelAndMission(
                        Course.courseNameToString(), Level.levelAndMissionToString());
                List<String> courseAndLevelAndMission = ParseUtil.stringToListStringByTrim(inputCourseAndLevelAndMission);

                return new PairRecord(courseAndLevelAndMission);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
