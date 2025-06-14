package utilities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.util.List;

public class CSVReaderUtil {

    public static List<CSVRecord> readCSV(String filePath) throws Exception {
        FileReader reader = new FileReader(filePath);
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
        return parser.getRecords();
    }
}
