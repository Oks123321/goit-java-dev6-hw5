package ua.goit.hw5.exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(String message) {
        super(message);
    }
}
