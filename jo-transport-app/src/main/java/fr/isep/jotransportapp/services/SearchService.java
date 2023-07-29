package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.model.parameters.SearchParameters;
import fr.isep.jotransportapp.model.responses.SearchResponse;

public interface SearchService {
    SearchResponse getResults(SearchParameters parameters);
}
