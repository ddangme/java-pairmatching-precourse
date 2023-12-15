package pairmatching;

import pairmatching.constants.Course;
import pairmatching.constants.ErrorMessage;
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
            pairMatching(pairRecord);
            return true;
        }
        if (skillMenu.equals(SkillMenu.PAIR_INQUIRY)) {
            return pairInquiry();
        }
        if (skillMenu.equals(SkillMenu.PAIR_INIT)) {
            pairService.initPairRecords();
            outputView.printPairRecordInitMessage();
            return true;
        }
        return false;
    }

    private boolean pairInquiry() {
        PairRecord pairRecord = getCourseAndLevelAndMission();
        PairRecord getPairRecord = pairService.getSamePairRecord(pairRecord);
        if (getPairRecord != null) {
            outputView.printPairMatchingResult(getPairRecord.pairCrewToString());
            return true;
        }
        outputView.printPairMatchingFailMessage();
        return true;
    }

    private void pairMatching(PairRecord pairRecord) {
        if (pairService.generatePairCrew(pairRecord)) {
            outputView.printPairMatchingResult(pairRecord.pairCrewToString());
            return;
        }
        inputReMatching(pairRecord);
    }

    private void inputReMatching(PairRecord pairRecord) {
        while (true) {
            try {
                String reMatchingChoice = inputView.inputReMatchingChoiceMessage();
                validateReMatchingChoice(reMatchingChoice);

                if (reMatchingChoice.equals("네")) {
                    pairService.rePair(pairRecord);
                    outputView.printPairMatchingResult(pairRecord.pairCrewToString());
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateReMatchingChoice(String value) {
        if (!value.equals("네") && !value.equals("아니오")) {
            throw new IllegalArgumentException(ErrorMessage.RE_MATCHING_ERROR_MESSAGE);
        }
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
