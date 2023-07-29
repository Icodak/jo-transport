package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.model.parameters.SearchParameters;
import fr.isep.jotransportapp.model.responses.SearchResponse;

public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponse getResults(SearchParameters parameters) {
        System.out.println(parameters.locationName);
        return null;
    }
}
