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
import java.util.*;

public class Application extends javafx.application.Application {
    public static final String APP_NAME = "Simulateur de transports en commun";

    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/fr/isep/jotransportapp/station-locations.csv";
        CSVReader csvReader = new CSVReader(csvFilePath);

        try {
            List<CSVRecord> records = csvReader.readRecords();
            Graph graph = new Graph();

            // Add stations and associate lines
            for (CSVRecord record : records) {
                String stationId = record.get("gares_id");
                String stationName = record.get("nom_long");
                String geoPoint = record.get(0); // Geo Point as column name doesn't work
                String[] parts = geoPoint.split(",");
                double latitude = Double.parseDouble(parts[0].trim());
                double longitude = Double.parseDouble(parts[1].trim());

                String lineId = record.get("idrefliga");
                String lineName = record.get("res_com");

                String terMetroValue = record.get("termetro");
                String terRerValue = record.get("terrer");
                String terTramValue = record.get("tertram");
                String terTrainValue = record.get("tertrain");
                String terValValue = record.get("terval");
                boolean isTerminus = !terMetroValue.equals("0") ||
                        !terRerValue.equals("0") ||
                        !terTramValue.equals("0") ||
                        !terTrainValue.equals("0") ||
                        !terValValue.equals("0");

                Station station = new Station(stationId, stationName, latitude, longitude);
                station.setLineId(lineId);
                station.setTerminus(isTerminus);
                graph.addStation(station);

                Line line = graph.getLineById(lineId);
                if (line == null) {
                    line = new Line(lineId, lineName);
                    graph.addLine(line);
                }
                line.addStation(station);
            }

            graph.parseAndSetupTerminusDistances();

            for (String lineId : graph.getAllLineIds()) {
                Line line = graph.getLineById(lineId);
                List<Station> stations = line.getStations();

                List<String> stationIds = new ArrayList<>();
                for (Station station : stations) {
                    stationIds.add(station.getStationId());
                }
                String startStationId = stationIds.get(0); // Choosing the first station as the start station
                Station startStation = graph.getStationById(startStationId);

                // Calculate distances from startStation to each station
                Map<String, Double> distances = new HashMap<>();
                for (String stationId : stationIds) {
                    Station station = graph.getStationById(stationId);
                    double distance = station.getDistanceToTerminus(); // Use terminus distances
                    distances.put(stationId, distance);
                }

                // Sort stationIds based on distances
                stationIds.sort(Comparator.comparingDouble(distances::get));

                Station previousStation = startStation;
                for (String stationId : stationIds) {
                    Station neighborStation = graph.getStationById(stationId);
                    if (!neighborStation.equals(previousStation)) {
                        double distanceToNeighbor = previousStation.getDistanceToNeighbor(neighborStation);
                        previousStation.addNeighbor(neighborStation, distanceToNeighbor);
                        neighborStation.addNeighbor(previousStation, distanceToNeighbor);
                        previousStation = neighborStation;
                    }
                }

            }
            testPath(graph, "160", "583"); // CFrom Château de Vincennes to Nation
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch();
    }

    public static void testPath(Graph graph, String startStationId, String endStationId) {
        Station startStation = graph.getStationById(startStationId);
        Station endStation = graph.getStationById(endStationId);

        if (startStation != null && endStation != null) {
            List<Station> path = graph.findShortestPath(startStationId, endStationId);
            System.out.println(path.size());

            if (path != null) {
                System.out.println("Path between " + startStation.getName() + " and " + endStation.getName() + ": ");
                for (Station station : path) {
                    System.out.println(station.getName());
                }
            } else {
                System.out.println("No path found between " + startStation.getName() + " and " + endStation.getName());
            }
        } else {
            System.out.println("Specified stations don't exist in the graph.");
        }
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
