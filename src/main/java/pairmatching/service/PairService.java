package pairmatching.service;

import pairmatching.domain.Crew;
import pairmatching.domain.PairRecord;

import java.util.ArrayList;
import java.util.List;

public class PairService {

    private List<Crew> crews;
    private List<PairRecord> pairRecords = new ArrayList<>();

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    public void generatePairCrew(PairRecord pairRecord) {
        pairRecords.add(pairRecord);
    }


}
