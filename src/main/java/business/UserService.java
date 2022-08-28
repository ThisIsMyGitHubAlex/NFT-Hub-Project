package business;

import domain.User;

public interface UserService {
    // scrivere il metodo che legge su file gli utenti
    User authenticate(String username, String password) throws UserNotFoundException, BusinessException;
}
