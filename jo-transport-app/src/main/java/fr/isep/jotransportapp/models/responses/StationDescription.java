package fr.isep.jotransportapp.models.responses;

import fr.isep.jotransportapp.models.Line;
import fr.isep.jotransportapp.models.TransportTypes;

import java.util.List;

public class StationDescription {
    public TransportTypes type;
    public String stationName;
    private List<Line> lines;

    public StationDescription(String stationName, List<Line> lines, TransportTypes type) {
        this.stationName = stationName;
        this.lines = lines;
        this.type = type;
    }

    public String getStationName() {
        return stationName;
    }

    public List<Line> getLines() {
        return lines;
    }
}
