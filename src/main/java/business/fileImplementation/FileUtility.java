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
        // the counter is written in the first line of the file
        // so we read it as a string and convert it to a number
        long positionCounter = Long.parseLong(br.readLine());
        fileData.setPositionCounter(positionCounter);

        // as long as there are lines written
        while ((row = br.readLine()) != null) {
            // add each line to the linelist by separating string by string by the separator
            rows.add(trim(row.split(COLUMN_SEPARATOR)));
        }
        // put the lines in filedata
        fileData.setRows(rows);
        return fileData;
    }

}
