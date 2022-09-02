package business.fileImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to Get a clean FileData (no spaces)
 * */
public class FileUtility {

    public final static String COLUMN_SEPARATOR = ",";

    // method to remove spaces
    public static final String[] trim(String[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
        }
        return s;
    }

    public static FileData readAllRows(String fileNamePath) throws IOException {
        FileData fileData = new FileData();

        BufferedReader br = new BufferedReader(new FileReader(fileNamePath));
        String row = null;
        List<String[]> rows = new ArrayList<>();
        // nella prima riga del file c'è scritto il contatore
        // quindi lo andiamo a leggere come stringa e lo convertiamo a nummero
        long positionCounter = Long.parseLong(br.readLine());
        fileData.setPositionCounter(positionCounter);

        // fino a quando ci sono righe scritte
        while ((row = br.readLine()) != null) {
            // aggiungi ogni riga alla lista delle righe separando Stringa per stringa tramite il separatore
            rows.add(trim(row.split(COLUMN_SEPARATOR)));
        }
        // inserisco le righe nel filedata
        fileData.setRows(rows);
        return fileData;
    }

}
