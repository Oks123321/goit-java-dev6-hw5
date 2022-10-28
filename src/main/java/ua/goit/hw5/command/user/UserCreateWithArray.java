package ua.goit.hw5.command.user;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.model.ApiResponse;
import ua.goit.hw5.model.User;
import ua.goit.hw5.service.UserService;
import ua.goit.hw5.view.View;

public class UserCreateWithArray implements Command {
    public static final String CREATE_USERS = "13";
    private final UserService userService;
    private final View view;

    public UserCreateWithArray(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }


    @Override
    public boolean canExecute(String input) {
        return input.equalsIgnoreCase(CREATE_USERS);
    }

    @Override
    public void execute(String input) {
        view.write("How many user will be create?");
        int count = Integer.parseInt(view.read());
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = userService.getUser(view);
        }
        ApiResponse response = userService.createWithArray(users);
        view.write(response.toString());
    }

}
