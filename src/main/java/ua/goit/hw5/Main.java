package ua.goit.hw5;

import ua.goit.hw5.command.*;
import ua.goit.hw5.command.pet.*;
import ua.goit.hw5.command.store.*;
import ua.goit.hw5.command.user.*;
import ua.goit.hw5.controller.ProjectManagementSystem;
import ua.goit.hw5.service.PetService;
import ua.goit.hw5.service.StoreService;
import ua.goit.hw5.service.UserService;
import ua.goit.hw5.utils.HttpUtils;
import ua.goit.hw5.view.Console;
import ua.goit.hw5.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new Console(scanner);
        HttpUtils httpUtils = new HttpUtils("https://petstore.swagger.io/v2");
        UserService userService = new UserService(httpUtils);
        StoreService storeService = new StoreService(httpUtils);
        PetService petService = new PetService(httpUtils);

        List<Command> commands = new ArrayList<>();
        commands.add(new Help(view));
        commands.add(new PetCommand(view));
        commands.add(new StoreCommand(view));
        commands.add(new UserCommand(view));
        commands.add(new Exit(view));

        commands.add(new PetAdd(petService, view));
        commands.add(new PetDelete(petService, view));
        commands.add(new PetFindById(petService, view));
        commands.add(new PetFindByStatus(petService, view));
        commands.add(new PetUpdateExisting(petService, view));
        commands.add(new PetUpdateWithFormData(petService, view));
        commands.add(new PetUploadImage(petService, view));

        commands.add(new StoreDeleteOrder(storeService, view));
        commands.add(new StoreFindOrderById(storeService, view));
        commands.add(new StoreGetInventory(storeService, view));
        commands.add(new StorePlaceOrder(storeService, view));

        commands.add(new UserCreate(userService, view));
        commands.add(new UserCreateWithArray(userService, view));
        commands.add(new UserCreateWithList(userService, view));
        commands.add(new UserDeleteByUsername(userService, view));
        commands.add(new UserGetByUsername(userService, view));
        commands.add(new UserLogin(userService, view));
        commands.add(new UserLogout(userService, view));
        commands.add(new UserUpdateByUsername(userService, view));


        ProjectManagementSystem projectManagementSystem = new ProjectManagementSystem(view, commands);
        projectManagementSystem.run();
    }
}