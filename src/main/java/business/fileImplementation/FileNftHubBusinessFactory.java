package business.fileImplementation;

import business.NftHubFactory;
import business.UserService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileNftHubBusinessFactory extends NftHubFactory {

    private UserService userService;

    private static final String REPOSITORY_BASE =
            "C:\\Users\\aless\\Desktop\\NFT_Hub\\NFT-Hub-Project\\src\\main\\resources\\data";

    // TODO resolve the path problem for the file
    private static final String USER_FILE_NAME = REPOSITORY_BASE + File.separator + "users.txt";

    private static final String FILE =
            "C:\\Users\\aless\\Desktop\\NFT_Hub\\NFT-Hub-Project\\src\\main\\resources\\data\\users";


    public FileNftHubBusinessFactory(){
       // userService = new FileUserServiceImplementation(USER_FILE_NAME);
        userService = new FileUserServiceImplementation(FILE);
    }
    @Override
    public UserService getUserService() {
        return userService;
    }
}
