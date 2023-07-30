package fr.isep.jotransportapp.viewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;

public class SearchResultVM {
    public String title;
    public Image image;
    public List<StationCardVM> stations;
    public SimpleStringProperty uuidProperty = new SimpleStringProperty("");
    public SimpleStringProperty titleProperty = new SimpleStringProperty("");
    private String uuid;

    SearchResultVM(TransportTypes type, String title, List<StationCardVM> stations, String uuid) {
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
        this.uuid = uuid;
    }

    public void onClick() {
        uuidProperty.set(uuid);
        titleProperty.set(title);
    }
}

