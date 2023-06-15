package services;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static utils.Constants.BASE_PATH;
import static utils.Constants.CONTACTS_FILE_NAME;
import static utils.Constants.DATA_DELETE_MSG;
import static utils.Constants.EXTENSION;
import static utils.Constants.INCORRECT_VALUE_MSG;

public class ContactsDeleteService {
    private ContactsReaderService readerService = new ContactsReaderService();
    private final String pathname = BASE_PATH + CONTACTS_FILE_NAME + EXTENSION;


    @SneakyThrows
    public void deleteContact() {
        System.out.println("Write number to delete: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String number = scanner.nextLine();
            String tmpFileName = BASE_PATH + "tmp.txt";
            Map<String, String> map = readerService.readContacts();
            if (map.containsKey(number)) {
                try (FileWriter fileWriter = new FileWriter(tmpFileName)) {
                    File file = new File(pathname);
                    map.remove(number);
                    map.forEach((key, value) -> {
                        try{
                            fileWriter.write(value + " " + key + "\n");
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    });

                    file.delete();
                    File tempFile = new File(tmpFileName);
                    tempFile.renameTo(file);
                    System.out.println(DATA_DELETE_MSG);
                }
            } else {
                System.out.println(INCORRECT_VALUE_MSG);
            }

        }

    }
}
