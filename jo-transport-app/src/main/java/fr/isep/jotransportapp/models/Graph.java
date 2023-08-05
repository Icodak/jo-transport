package fr.isep.jotransportapp.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final Map<String, Station> stations;
    private final Map<String, Line> lines;

    public Graph() {
        stations = new HashMap<>();
        lines = new HashMap<>();
    }

    public void addStation(Station station) {
        stations.put(station.getStationId(), station);
    }

    public void addLine(Line line) {
        lines.put(line.getLineId(), line);
    }

    public Station getStationById(String stationId) {
        return stations.get(stationId);
    }

    public Line getLineById(String lineId) {
        return lines.get(lineId);
    }

    public Set<String> getAllStationIds() {
        return stations.keySet();
    }

    public Set<String> getAllLineIds() {
        return lines.keySet();
    }
}
