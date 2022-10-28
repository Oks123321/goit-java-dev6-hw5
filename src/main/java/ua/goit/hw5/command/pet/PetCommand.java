package ua.goit.hw5.command.pet;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.command.Exit;
import ua.goit.hw5.command.Help;
import ua.goit.hw5.view.View;

public class PetCommand implements Command {

    public static final String PET = "pet";
    private final View view;

    public PetCommand(View view) {
        this.view = view;
    }


    @Override
    public boolean canExecute(String input) {
        return input.equals(PET);
    }

    @Override
    public void execute(String input) {
        view.write(String.format("Enter %s to add new pet", PetAdd.ADD_NEW_PET));
        view.write(String.format("Enter %s to delete pet", PetDelete.DELETE));
        view.write(String.format("Enter %s to find pet by id", PetFindById.FIND_BY_ID));
        view.write(String.format("Enter %s to find pet by status", PetFindByStatus.FIND_BY_STATUS));
        view.write(String.format("Enter %s to update existing pet", PetUpdateExisting.UPDATE_EXISTING));
        view.write(String.format("Enter %s to update pet with form data", PetUpdateWithFormData.UPDATE_BY_FORM_DATA));
        view.write(String.format("Enter %s to upload image for pet", PetUploadImage.UPLOAD_IMAGE));
        view.write(String.format("Enter %s to see all commands", Help.HELP));
        view.write(String.format("Enter %s to exit program", Exit.EXIT));
    }

}
