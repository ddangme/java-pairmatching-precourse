package pairmatching.service;

import pairmatching.constants.Course;
import pairmatching.domain.Crew;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class GenerateCrewService {

    public List<Crew> generateCrews() {
        List<Crew> crews = new ArrayList<>();

        generateBackendCrew(crews);
        generateFrontendCrew(crews);

        return crews;
    }

    private void generateBackendCrew(List<Crew> crews) {
        URL frontend = getClass().getClassLoader().getResource("backend-crew.md");
        try {
            List<String> backendCrewNames = Files.readAllLines(Path.of(frontend.getPath()));
            for (String name : backendCrewNames) {
                crews.add(new Crew(Course.BACKEND, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateFrontendCrew(List<Crew> crews) {
        URL frontend = getClass().getClassLoader().getResource("frontend-crew.md");
        try {
            List<String> frontendCrewNames = Files.readAllLines(Path.of(frontend.getPath()));
            for (String name : frontendCrewNames) {
                crews.add(new Crew(Course.FRONTEND, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
