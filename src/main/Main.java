package main;

import exception.InvalidUserException;
import model.User;
import service.LoginService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        LoginService loginService =
                new LoginService();

        try {

            System.out.println(
                    "===== LOGIN ====="
            );

            System.out.print(
                    "Enter Email: "
            );

            String email =
                    scanner.nextLine();

            System.out.print(
                    "Enter Password: "
            );

            String password =
                    scanner.nextLine();

            User user =
                    loginService.login(
                            email,
                            password
                    );

            System.out.println(
                    "\nWelcome "
                    + user.getName()
            );

            Dashboard dashboard =
                    new Dashboard();

            dashboard.showMenu();

        } catch (
                InvalidUserException e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }
}