package fr.isep.jotransportapp.viewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TripProposalVM {

    public String name;
    public AffluenceLevel affluenceLevel;
    public Image affluencePicto;
    public List<StationCardVM> stations;
    public Double price;
    public String formattedPrice;
    public String formattedDuration;
    public Integer duration;

    public TripProposalVM(
            String name,
            AffluenceLevel affluenceLevel,
            List<StationCardVM> stations,
            Double price,
            Integer duration) {
        this.name = name;
        this.affluenceLevel = affluenceLevel;
        this.stations = stations;
        this.price = price;
        formattedPrice = formatPrice(price);
        switch (affluenceLevel) {
            case NONE ->
                    affluencePicto = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/none.png")).toString());
            case LOW ->
                    affluencePicto = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/low.png")).toString());
            case MEDIUM ->
                    affluencePicto = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/medium.png")).toString());
            case HIGH ->
                    affluencePicto = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/high.png")).toString());
        }
        this.duration = duration;
        formattedDuration = formatDuration(duration);
    }

    private String formatPrice(Double price) {
        // TODO
        return "" + price + "€";
    }

    private String formatDuration(Integer duration) {
        // TODO
        return "" + duration + "min";
    }
    public void onClick() {
        System.out.println("pouet");
    }
}

