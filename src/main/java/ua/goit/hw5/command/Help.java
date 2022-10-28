package ua.goit.hw5.command;

import ua.goit.hw5.command.pet.PetCommand;
import ua.goit.hw5.command.store.StoreCommand;
import ua.goit.hw5.command.user.UserCommand;
import ua.goit.hw5.view.View;

public class Help implements Command{
    public static final String HELP = "help";
     private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(HELP);
    }

    @Override
    public void execute(String input) {

        view.write(String.format("Enter %s to see commands of pet", PetCommand.PET));
        view.write(String.format("Enter %s to see commands of store", StoreCommand.STORE));
        view.write(String.format("Enter %s to see commands of user", UserCommand.USER));
        view.write(String.format("Enter %s to exit program", Exit.EXIT));
    }
}
