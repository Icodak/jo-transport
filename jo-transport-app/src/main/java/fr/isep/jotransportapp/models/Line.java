package fr.isep.jotransportapp.models;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String lineId;
    private final String name;
    private final Color color;
    private final List<Station> stations;

    public Line(String name, Color color) {
        this.name = name;
        this.color = color;
        this.stations = new ArrayList<>();
    }

    public Line(String lineId, String name, Color color) {
        this.lineId = lineId;
        this.name = name;
        this.color = color;
        this.stations = new ArrayList<>();
    }

    public String getLineId() {
        return lineId;
    }

    public List<Station> getStations() {
        return stations;
    }
    public void addStation(Station station) {
        stations.add(station);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineId='" + lineId + '\'' +
                ", name='" + name + '\'' +
                ", stations=" + stations +
                '}';
    }
}

