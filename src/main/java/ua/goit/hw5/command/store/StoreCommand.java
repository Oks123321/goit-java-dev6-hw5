package ua.goit.hw5.command.store;

import ua.goit.hw5.command.Command;
import ua.goit.hw5.command.Exit;
import ua.goit.hw5.command.Help;
import ua.goit.hw5.view.View;

public class StoreCommand implements Command {
    public static final String STORE = "store";
    private final View view;

    public StoreCommand(View view) {
        this.view = view;
    }


    @Override
    public boolean canExecute(String input) {
        return input.equals(STORE);
    }

    @Override
    public void execute(String input) {
        view.write(String.format("Enter %s to place order for a pet", StorePlaceOrder.PLACE_ORDER));
        view.write(String.format("Enter %s to find order by orderId", StoreFindOrderById.FIND_ORDER_BY_ID));
        view.write(String.format("Enter %s to delete order by orderId", StoreDeleteOrder.DELETE_ORDER_BY_ID));
        view.write(String.format("Enter %s to get inventory", StoreGetInventory.GET_INVENTORY));
        view.write(String.format("Enter %s to see all commands", Help.HELP));
        view.write(String.format("Enter %s to exit program", Exit.EXIT));
    }

}
