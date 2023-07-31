package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.Line;

import java.util.List;

public class TripDetailsVM {
    /*
     * Details the different stations to take along a trip of a specific line
     * */
    public Line line;
    public List<String> stations;

    public TripDetailsVM(Line line, List<String> stations) {
        this.line = line;
        this.stations = stations;
    }
}
