package business.fileImplementation;

import java.util.List;

public class FileData {

    private long positionCounter;
    private List<String []> rows;

    public long getPositionCounter() {
        return positionCounter;
    }

    public void setPositionCounter(long positionCounter) {
        this.positionCounter = positionCounter;
    }

    public List<String[]> getRows() {
        return rows;
    }

    public void setRows(List<String[]> rows) {
        this.rows = rows;
    }
}
