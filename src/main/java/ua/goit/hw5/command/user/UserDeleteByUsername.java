package ua.goit.hw5.command.user;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.model.ApiResponse;
import ua.goit.hw5.service.UserService;
import ua.goit.hw5.view.View;

public class UserDeleteByUsername implements Command {
    public static final String DELETE_USER = "15";
    private final UserService userService;
    private final View view;

    public UserDeleteByUsername(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equalsIgnoreCase(DELETE_USER);
    }

    @Override
    public void execute(String input) {
        view.write("Write username for delete");
        String username = view.read();
        ApiResponse response = userService.delete(username);
        view.write(response.toString());
    }
}
