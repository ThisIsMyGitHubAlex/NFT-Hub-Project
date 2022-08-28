package business.fileImplementation;

import business.BusinessException;
import business.UserNotFoundException;
import business.UserService;
import domain.User;

public class FileUserServiceImplementation implements UserService {

    String userFilename;


    public FileUserServiceImplementation(String userFilename) {
        this.userFilename =userFilename;
    }
    @Override
    public User authenticate(String username, String password) throws UserNotFoundException, BusinessException {
        return null;
    }
}
