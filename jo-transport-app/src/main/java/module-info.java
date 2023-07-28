module fr.isep.jotransportapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.isep.jotransportapp to javafx.fxml;
    exports fr.isep.jotransportapp;
    exports fr.isep.jotransportapp.components;
    opens fr.isep.jotransportapp.components to javafx.fxml;
}