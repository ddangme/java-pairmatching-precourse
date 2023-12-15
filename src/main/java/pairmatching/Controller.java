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

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    PairService pairService = new PairService();

    public void run() {
        setCrews();

        SkillMenu skillMenu = menuChoice();
        runSkill(skillMenu);
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

    private void runSkill(SkillMenu skillMenu) {
        if (skillMenu.equals(SkillMenu.PAIR_MATCHING)) {
            inputCourseAndLevelAndMission();
            return;
        }
        if (skillMenu.equals(SkillMenu.PAIR_INQUIRY)) {
            return;
        }
        if (skillMenu.equals(SkillMenu.PAIR_INIT)) {
            return;
        }
        if (skillMenu.equals(SkillMenu.PROGRAM_SHUT_DOWN)) {

        }
    }

    private void inputCourseAndLevelAndMission() {
        while (true) {
            try {
                String inputCourseAndLevelAndMission = inputView.inputCourseAndLevelAndMission(
                        Course.courseNameToString(), Level.levelAndMissionToString());
                List<String> courseAndLevelAndMission = ParseUtil.stringToListStringByTrim(inputCourseAndLevelAndMission);

                PairRecord pairRecord = new PairRecord(courseAndLevelAndMission);
                pairService.generatePairCrew(pairRecord);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
