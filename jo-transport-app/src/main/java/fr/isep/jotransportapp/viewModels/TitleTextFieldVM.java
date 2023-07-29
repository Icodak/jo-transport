package fr.isep.jotransportapp.viewModels;

import javafx.beans.property.SimpleStringProperty;

public class TitleTextFieldVM {
    public final SimpleStringProperty title = new SimpleStringProperty("");
    public final SimpleStringProperty placeholder = new SimpleStringProperty("");
    public final SimpleStringProperty search = new SimpleStringProperty("");

    // Convenience init
    public TitleTextFieldVM(String title, String placeholder) {
        this.title.set(title);
        this.placeholder.set(placeholder);
    }

    public TitleTextFieldVM() {
    }
}
