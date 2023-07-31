package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.parameters.TripParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.TripResponse;

public interface MainService {
    SearchResponse getResults(SearchParameters parameters);

    TripResponse getTrips(TripParameters parameters);
}

