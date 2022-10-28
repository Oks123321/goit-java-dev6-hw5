package ua.goit.hw5.command.user;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.command.Exit;
import ua.goit.hw5.command.Help;
import ua.goit.hw5.view.View;

public class UserCommand implements Command {
    public static final String USER = "user";
    private final View view;

    public UserCommand(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equalsIgnoreCase(USER);
    }

    @Override
    public void execute(String input) {
        view.write(String.format("Enter %s to create user", UserCreate.CREATE_USER));
        view.write(String.format("Enter %s to create users with array", UserCreateWithArray.CREATE_USERS));
        view.write(String.format("Enter %s to create users with list", UserCreateWithList.CREATE_USERS));
        view.write(String.format("Enter %s to delete user by username", UserDeleteByUsername.DELETE_USER));
        view.write(String.format("Enter %s to get user by username", UserGetByUsername.GET_USER_BY_USERNAME));
        view.write(String.format("Enter %s to login user", UserLogin.LOGIN_USER));
        view.write(String.format("Enter %s to logout user", UserLogout.LOGOUT_USER));
        view.write(String.format("Enter %s to update user by username", UserUpdateByUsername.UPDATE_USER_BY_USERNAME));
        view.write(String.format("Enter %s to see all commands", Help.HELP));
        view.write(String.format("Enter %s to exit program", Exit.EXIT));
    }
}
