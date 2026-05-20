package service;

import dao.UserDAO;
import exception.InvalidUserException;
import model.User;

public class LoginService {

    UserDAO userDAO = new UserDAO();

    public User login(
            String email,
            String password
    ) throws InvalidUserException {

        User user =
                userDAO.loginUser(
                        email,
                        password
                );

        if (user == null) {

            throw new InvalidUserException(
                    "Invalid Email or Password!"
            );
        }

        return user;
    }
}