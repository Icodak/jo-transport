package fr.isep.jotransportapp.models;

import fr.isep.jotransportapp.viewModels.AffluenceLevel;

import java.util.List;

public class TextEvent {
    public String text;
    public double x;
    public double y;

    public TextEvent(String text, double x, double y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }
}

