package fr.isep.jotransportapp.models;

import javafx.scene.paint.Color;

public class Line {
    private String lineId;
    public String name;
    public Color color;

    public Line(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Line(String lineId, String name) {
        this.lineId = lineId;
        this.name = name;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String id) {
        this.lineId = id;
    }
}

