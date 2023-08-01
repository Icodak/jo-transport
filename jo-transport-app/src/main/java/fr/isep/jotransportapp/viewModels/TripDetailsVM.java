package fr.isep.jotransportapp.viewModels;

import java.util.List;

public class TripDetailsVM {
    /*
     * Details the different stations to take along a trip of a specific line
     * */

    public LineCardVM lineCardVM;
    public List<String> stations;
    public String firstStation;


    public TripDetailsVM(LineCardVM lineCardVM, List<String> stations) {
        this.lineCardVM = lineCardVM;
        this.stations = stations;
        firstStation = stations.stream().findFirst().orElse("");
    }


}
