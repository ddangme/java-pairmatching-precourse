package pairmatching;

import pairmatching.constants.SkillMenu;
import pairmatching.domain.Crew;
import pairmatching.service.GenerateCrewService;
import pairmatching.service.PairService;
import pairmatching.view.InputView;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    PairService pairService = new PairService();

    public void run() {
        setCrews();

        SkillMenu skillMenu = menuChoice();
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

}
