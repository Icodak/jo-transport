package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.Station;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;

public class SearchResultVM {
    public String title;
    public Image image;
    public List<Station> stations;

    SearchResultVM(TransportTypes type, String title, List<Station> stations) {
        System.out.println("");
        switch (type) {
            case TRAIN ->
                    image = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/train.png")).toString());
            case METRO ->
                    image = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/metro.png")).toString());
            case BUS ->
                    image = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/bus.png")).toString());
        }
        this.title = title;
        this.stations = stations;
    }
}

