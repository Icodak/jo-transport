module fr.isep.jotransportapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.isep.jotransportapp to javafx.fxml;
    exports fr.isep.jotransportapp;
}