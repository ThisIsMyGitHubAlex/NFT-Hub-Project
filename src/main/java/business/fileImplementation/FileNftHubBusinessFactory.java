package business.fileImplementation;

import business.NftHubFactory;
import business.UserService;

import java.io.File;

public class FileNftHubBusinessFactory extends NftHubFactory {

    private UserService userService;

    private static final String REPOSITORY_BASE = "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "data";




    private static final String USER_FILE_NAME = REPOSITORY_BASE + File.separator + "users";


    public FileNftHubBusinessFactory() {
        userService = new FileUserServiceImplementation(USER_FILE_NAME);
    }

    @Override
    public UserService getUserService() {
        return userService;
    }
}
