package fr.isep.jotransportapp.Domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;

public interface MainViewModel {
    String btnTitle = "Click Me";
    StringProperty labelTitle = new SimpleStringProperty("");

    void onTap(ActionEvent event);
}
