package business;

import domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User authenticate(String username, String password) throws UserNotFoundException, BusinessException, IOException;

    void signUp(String username, String password) throws IOException;

    boolean resetUsername(String newUsername, String currentUsername) throws FileNotFoundException;

    boolean resetPassword(String newPassword, String username) throws FileNotFoundException;

    List<User> getUserList() throws BusinessException;
}
