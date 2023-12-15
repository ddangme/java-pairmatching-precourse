package pairmatching;

import pairmatching.domain.Crew;
import pairmatching.service.GenerateCrewService;

import java.util.List;

public class Controller {
    public void run() {
        List<Crew> crews = generateCrews();
    }

    private List<Crew> generateCrews() {
        GenerateCrewService generateCrewService = new GenerateCrewService();
        return generateCrewService.generateCrews();
    }

}
