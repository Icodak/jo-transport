package fr.isep.jotransportapp;

import fr.isep.jotransportapp.components.MainController;
import fr.isep.jotransportapp.models.Graph;
import fr.isep.jotransportapp.models.Line;
import fr.isep.jotransportapp.models.Station;
import fr.isep.jotransportapp.util.CSVReader;
import fr.isep.jotransportapp.viewModels.MainVM;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class Application extends javafx.application.Application {
    public static final String APP_NAME = "Simulateur de transports en commun";

    public static void main(String[] args) {
        String csvFilePath = "jo-transport-app/src/main/resources/fr/isep/jotransportapp/emplacement-des-gares-idf.csv";
        CSVReader csvReader = new CSVReader(csvFilePath);

        try {
            List<CSVRecord> records = csvReader.readRecords();
            for (CSVRecord record : records) {
                String stationId = record.get(2);
                String stationName = record.get(3);
                String lineName = record.get(12);
                String lineId = record.get(10);
                System.out.println("StationId: " + stationId + ", Station: " + stationName + ", LineId:" + lineId + ", Line: " + lineName);
            }
            Graph graph = new Graph();
            for (CSVRecord record : records) {
                String stationId = record.get("gares_id");
                String stationName = record.get("nom_long");
                Station station = new Station(stationId, stationName);
                graph.addStation(station);

                String lineId = record.get("idrefliga");
                String lineName = record.get("res_com");
                Line line = new Line(lineId, lineName);
                graph.addLine(line);
            }
            // Test :
            System.out.println("Stations dans le graphe :");
            for (String stationId : graph.getAllStationIds()) {
                Station station = graph.getStationById(stationId);
                System.out.println("Station : " + station.getName() + ", ID : " + station.getStationId());
            }

            System.out.println("\nLignes dans le graphe :");
            for (String lineId : graph.getAllLineIds()) {
                Line line = graph.getLineById(lineId);
                System.out.println("Ligne : " + line.name + ", ID : " + line.getLineId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/jotransportapp/components/MainWindow.fxml"));
        Scene scene = new Scene(loader.load());
        SetFullscreen(stage);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/fr/isep/jotransportapp/images/icon.png"))));
        stage.setTitle(APP_NAME);

        MainVM viewModel = new MainVM(scene);
        MainController mainController = loader.getController();
        mainController.bind(viewModel);

        stage.setScene(scene);
        stage.show();
    }

    void SetFullscreen(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX(screenBounds.getMinX());
        stage.setY(screenBounds.getMinY());
        stage.setWidth(screenBounds.getWidth());
        stage.setHeight(screenBounds.getHeight());
    }

}
