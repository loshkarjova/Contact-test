package views;

import services.AppService;
import utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {
    private final AppService service = new AppService();
    private Scanner scanner;

    public void chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> service.readService();
                case 2 -> service.writeContact();
                case 3 -> service.deleteService();
                case 4 -> service.findService();
                case 0 -> getOutput(option, Constants.APP_CLOSE_MSG);
                default -> getOutput(option, Constants.INCORRECT_VALUE_MSG);

            }
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);

        }
    }

    private void showMenu() {
        System.out.print("""
                  ______ MENU ___________
                1 - View contacts.
                2 - Create a contact.
                3 - Delete contact.
                4 - Find a contact by number or name.
                0 - Close the App.
                """);
    }


    public void getOutput(int choice, String output) {
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}
