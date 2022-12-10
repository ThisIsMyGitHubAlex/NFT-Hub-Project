package business.fileImplementation;

import business.NftHubFactory;
import business.NftService;
import business.UserService;

import java.io.File;

public class FileNftHubBusinessFactory extends NftHubFactory {

    private UserService userService;
    private NftService nftService;

    private static final String REPOSITORY_BASE = "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "data";

    private static final String USER_FILE_NAME = REPOSITORY_BASE + File.separator + "users";
    private static final String IMAGE_COUNTER_FILE_NAME =
            REPOSITORY_BASE + File.separator + "NFTs"+File.separator +"image-count";
    private static final String NFT_DIRECTORY = REPOSITORY_BASE + File.separator + "NFTs";


    public FileNftHubBusinessFactory() {
        userService = new FileUserServiceImplementation(USER_FILE_NAME);
        nftService = new FileNftServiceImplementation(IMAGE_COUNTER_FILE_NAME,NFT_DIRECTORY);
    }


    @Override
    public UserService getUserService() {
        return userService;
    }
    @Override
    public NftService getNftService(){
        return nftService;
    }
}
