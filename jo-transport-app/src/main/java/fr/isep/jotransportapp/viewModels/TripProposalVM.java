package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.AffluenceLevel;
import fr.isep.jotransportapp.models.TransportTypes;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;

public class TripProposalVM {

    public String name;
    public AffluenceLevel affluenceLevel;
    public Image affluencePicto;
    public List<LineCardVM> lines;
    public Double price;
    public String formattedPrice;
    public String formattedDuration;
    public Integer duration;
    public Runnable onClick;
    public List<TransportTypes> transportTypes;

    public TripProposalVM(
            String name,
            AffluenceLevel affluenceLevel,
            List<LineCardVM> lines,
            Double price,
            Integer duration,
            Runnable onClick,
            List<TransportTypes> transportTypes) {
        this.name = name;
        this.affluenceLevel = affluenceLevel;
        this.lines = lines;
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
        this.onClick = onClick;
        this.transportTypes = transportTypes;
    }

    private String formatPrice(Double price) {
        // TODO
        return price + "€";
    }

    private String formatDuration(Integer duration) {
        // TODO
        return duration + "min";
    }


}

