module fr.isep.jotransportapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.isep.jotransportapp to javafx.fxml;
    exports fr.isep.jotransportapp;
    exports fr.isep.jotransportapp.Presentation;
    opens fr.isep.jotransportapp.Presentation to javafx.fxml;
}