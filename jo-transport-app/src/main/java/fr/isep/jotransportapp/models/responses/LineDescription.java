package fr.isep.jotransportapp.models.responses;

import fr.isep.jotransportapp.models.Line;
import fr.isep.jotransportapp.viewModels.TransportTypes;

import java.util.List;

public class LineDescription {
    public List<Line> lines;
    public String title;
    public TransportTypes type;
    public String uuid;

    public LineDescription(List<Line> lines, String title, TransportTypes type, String uuid) {
        this.lines = lines;
        this.title = title;
        this.type = type;
        this.uuid = uuid;
    }
}
