package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.TransportTypes;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;

public class SearchResultVM {
    private final String uuid;
    public String title;
    public Image image;
    public List<LineCardVM> lines;
    public SimpleStringProperty uuidProperty = new SimpleStringProperty("");
    public SimpleStringProperty titleProperty = new SimpleStringProperty("");

    SearchResultVM(TransportTypes type, String title, List<LineCardVM> lines, String uuid) {
        switch (type) {
            case TRAIN ->
                    image = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/train.png")).toString());
            case METRO ->
                    image = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/metro.png")).toString());
            case BUS ->
                    image = new Image(Objects.requireNonNull(getClass().getResource("/fr/isep/jotransportapp/images/bus.png")).toString());
        }
        this.title = title;
        this.lines = lines;
        this.uuid = uuid;
    }

    public void onClick() {
        titleProperty.set(title);
        uuidProperty.set(uuid);
    }

    @Override
    public String toString() {
        return "SearchResultVM{" +
                "title='" + title + '\'' +
                ", image=" + image +
                ", lines=" + lines +
                ", titleProperty=" + titleProperty +
                '}';
    }
}

