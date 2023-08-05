module fr.isep.jotransportapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.csv;


    opens fr.isep.jotransportapp to javafx.fxml;
    exports fr.isep.jotransportapp;
    exports fr.isep.jotransportapp.components;
    opens fr.isep.jotransportapp.components to javafx.fxml;
}