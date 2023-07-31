package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;

public interface MainService {
    SearchResponse getResults(SearchParameters parameters);
}
