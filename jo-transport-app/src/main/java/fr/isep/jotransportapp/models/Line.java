package fr.isep.jotransportapp.models;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String lineId;
    private String name;
    private Color color;
    private List<Station> stations;

    public Line(String name, Color color) {
        this.name = name;
        this.color = color;
        this.stations = new ArrayList<>();
    }

    public Line(String lineId, String name) {
        this.lineId = lineId;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
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

