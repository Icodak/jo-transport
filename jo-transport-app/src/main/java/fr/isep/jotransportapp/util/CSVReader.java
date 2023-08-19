package fr.isep.jotransportapp.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CSVReader {
    private final String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public List<CSVRecord> readRecords() throws IOException {
        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().builder()
                     .setDelimiter(';')
                     .build())) {
            return csvParser.getRecords();
        }
    }
}
