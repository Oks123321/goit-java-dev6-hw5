package ua.goit.hw5.command.pet;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.model.Pet;
import ua.goit.hw5.service.PetService;
import ua.goit.hw5.view.View;

public class PetAdd implements Command {

    public static final String ADD_NEW_PET = "1";
    private final PetService petService;
    private final View view;

    public PetAdd(PetService petService, View view) {
        this.petService = petService;
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equalsIgnoreCase(ADD_NEW_PET);
    }

    @Override
    public void execute(String input) {
        Pet pet = petService.getPet(view);
        Pet addedPet = petService.addPet(pet);
        view.write(addedPet.toString());
    }

}
