package business.fileImplementation;

import business.NftService;

public class FileNftServiceImplementation implements NftService {
    String imageCounterFilename;

    public FileNftServiceImplementation(String imageCounterFilename) {
        this.imageCounterFilename = imageCounterFilename;
    }

    // TODO Write the method that returns the number of images present
    @Override
    public int getImageCounter() {
        return 0;
    }
}
