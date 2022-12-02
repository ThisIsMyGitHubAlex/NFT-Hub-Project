package business.fileImplementation;

import business.NftService;

public class FileNftServiceImplementation implements NftService {
    String imageCounterFilename;

    public FileNftServiceImplementation(String imageCounterFilename) {
        this.imageCounterFilename = imageCounterFilename;
    }

    // TODO Scrivere il metodo che ritorna il numero di immagini presenti
    @Override
    public int getImageCounter() {
        return 0;
    }
}
