package ua.goit.hw5.view;

import ua.goit.hw5.command.Help;
import ua.goit.hw5.exceptions.ExitException;

import java.util.Scanner;

public class Console implements View {
    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
//        if (!scanner.nextLine().equalsIgnoreCase("exit")) {
//            scanner.nextLine();
//        } else new ExitException();
        return scanner.nextLine();
    }
}
