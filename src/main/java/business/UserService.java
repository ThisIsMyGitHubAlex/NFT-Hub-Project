package business;

import domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserService {
    // scrivere il metodo che legge su file gli utenti
    User authenticate(String username, String password) throws UserNotFoundException, BusinessException, IOException;

    void signUp(String username, String password) throws IOException;

    boolean resetUsername(String newUsername, String currentUsername) throws FileNotFoundException;

    boolean resetPassword(String newPassword, String username) throws FileNotFoundException;
}
