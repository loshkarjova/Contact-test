package services;

import lombok.SneakyThrows;
import utils.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ContactsWriterService {
    private final String pathname = Constants.BASE_PATH + Constants.CONTACTS_FILE_NAME + Constants.EXTENSION;


    @SneakyThrows
    public void checkFile() {
        File contactsFile = new File(pathname);
        if (!contactsFile.exists()) {
            Files.createFile(Path.of(pathname));
        }
    }

    @SneakyThrows
    public void addContact() {
        try (FileWriter fileWriter = new FileWriter(pathname, true);
             FileReader fileReader = new FileReader(pathname);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write Name:");
            String name = scanner.nextLine();
            System.out.println("Write Number:");
            String number = scanner.nextLine();
            String line = bufferedReader.readLine();
            String contact = name + " " + number;
            if (line == null) {
                bufferedWriter.write(contact);
            }else {
                bufferedWriter.write("\n" + contact);
            }

        }
    }



}
