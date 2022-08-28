package business;

import domain.User;

public interface UserService {
    User authenticate(String username, String password) throws UserNotFoundException, BusinessException;
}
