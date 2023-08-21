package fr.isep.jotransportapp.models;

import java.util.List;

public class LineDetails {
    /*
     * Details the different stations to take along a trip of a specific line
     * */
    public Line line;
    public List<String> stations;

    public LineDetails(Line line, List<String> stations) {
        this.line = line;
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "LineDetails{" +
                "line=" + line +
                ", stations=" + stations +
                '}';
    }
}
