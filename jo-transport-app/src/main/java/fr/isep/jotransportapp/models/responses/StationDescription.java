package fr.isep.jotransportapp.models.responses;

import fr.isep.jotransportapp.models.Line;
import fr.isep.jotransportapp.models.TransportTypes;

import java.util.List;

public class StationDescription {
    public TransportTypes type;
    public String stationName;
    private List<Line> lines;
    public String uuid;

    public StationDescription(String stationName, List<Line> lines, TransportTypes type, String uuid) {
        this.stationName = stationName;
        this.lines = lines;
        this.type = type;
        this.uuid = uuid;
    }

    public String getStationName() {
        return stationName;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "StationDescription{" +
                "type=" + type +
                ", stationName='" + stationName + '\'' +
                //", lines=" + lines +
                '}';
    }
}
