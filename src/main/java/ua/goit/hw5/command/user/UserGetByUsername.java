package ua.goit.hw5.command.user;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.model.User;
import ua.goit.hw5.service.UserService;
import ua.goit.hw5.view.View;

public class UserGetByUsername implements Command {
    public static final String GET_USER_BY_USERNAME = "16";
    private final UserService userService;
    private final View view;

    public UserGetByUsername(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equalsIgnoreCase(GET_USER_BY_USERNAME);
    }

    @Override
    public void execute(String input) {
        view.write("Write username");
        String username = view.read();
        User user = userService.getUserByUsername(username);
        view.write(user.toString());
    }
}
