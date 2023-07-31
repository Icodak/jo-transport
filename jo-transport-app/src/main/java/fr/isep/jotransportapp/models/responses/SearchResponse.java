package fr.isep.jotransportapp.models.responses;

import java.util.List;

public class SearchResponse {
    public List<LineDescription> lines;

    public SearchResponse(List<LineDescription> lines) {
        this.lines = lines;
    }
}
