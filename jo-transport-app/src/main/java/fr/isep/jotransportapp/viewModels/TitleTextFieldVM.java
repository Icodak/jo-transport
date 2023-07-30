package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.TextEvent;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.UUID;

public class TitleTextFieldVM {
    public final SimpleStringProperty title = new SimpleStringProperty("");
    public final SimpleStringProperty placeholder = new SimpleStringProperty("");
    public final SimpleBooleanProperty hasCross = new SimpleBooleanProperty(false);
    public final SimpleBooleanProperty hasClicked = new SimpleBooleanProperty(false);

    public final SimpleBooleanProperty hasClickedTextField = new SimpleBooleanProperty(false);

    public final SimpleObjectProperty<TextEvent> textEventProperty = new SimpleObjectProperty<>();

    public String id = UUID.randomUUID().toString();

    public final SimpleStringProperty tripUuid = new SimpleStringProperty("");
    public final SimpleStringProperty tripTitle = new SimpleStringProperty("");

    // Convenience init
    public TitleTextFieldVM(String title, String placeholder) {
        this.title.set(title);
        this.placeholder.set(placeholder);
    }

    public TitleTextFieldVM() {
    }
}
