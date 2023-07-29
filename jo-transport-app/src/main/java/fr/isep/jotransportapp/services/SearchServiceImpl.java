package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;

public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponse getResults(SearchParameters parameters) {
        System.out.println(parameters.locationName);
        return null;
    }
}
