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

    public Line(String lineId, String name) {
        this.lineId = lineId;
        this.name = name;
        this.color = determineColorFromName(name);
        this.stations = new ArrayList<>();
    }

    private Color determineColorFromName(String name) {
        if (name.equalsIgnoreCase("METRO 1")) {
            return Color.YELLOW;
        }
        if (name.equalsIgnoreCase("METRO 2")) {
            return Color.LIGHTBLUE;
        }
        if (name.equalsIgnoreCase("METRO 3")) {
            return Color.BROWN;
        }
        if (name.equalsIgnoreCase("METRO 3bis")) {
            return Color.LIGHTSKYBLUE;
        }
        if (name.equalsIgnoreCase("METRO 4")) {
            return Color.DEEPPINK;
        }
        if (name.equalsIgnoreCase("METRO 5")) {
            return Color.ORANGE;
        }
        if (name.equalsIgnoreCase("METRO 6")) {
            return Color.LIGHTGREEN;
        }
        if (name.equalsIgnoreCase("METRO 7")) {
            return Color.LIGHTPINK;
        }
        if (name.equalsIgnoreCase("METRO 7bis")) {
            return Color.LIGHTGREEN;
        }
        if (name.equalsIgnoreCase("METRO 8")) {
            return Color.MEDIUMPURPLE;
        }
        if (name.equalsIgnoreCase("METRO 9")) {
            return Color.DARKOLIVEGREEN;
        }
        if (name.equalsIgnoreCase("METRO 10")) {
            return Color.LIGHTYELLOW;
        }
        if (name.equalsIgnoreCase("METRO 11")) {
            return Color.BROWN;
        }
        if (name.equalsIgnoreCase("METRO 12")) {
            return Color.GREEN;
        }
        if (name.equalsIgnoreCase("METRO 13")) {
            return Color.LIGHTSKYBLUE;
        }
        if (name.equalsIgnoreCase("METRO 14")) {
            return Color.PURPLE;
        }
        return Color.GREY;
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

