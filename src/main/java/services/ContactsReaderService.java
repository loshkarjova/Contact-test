package services;

import lombok.SneakyThrows;
import utils.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContactsReaderService {
    private final String pathname = Constants.BASE_PATH + Constants.CONTACTS_FILE_NAME + Constants.EXTENSION;


    @SneakyThrows
    public Map<String, String> readContacts() {
        Map<String, String> map = new LinkedHashMap<>();

        try (FileReader fileReader = new FileReader(pathname);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.isBlank()) {
                    String[] s = line.split(" ");
                    map.put(s[1], s[0]);
                }
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
        return map;
    }

    public void outputRead() {
        Map<String, String> map = readContacts();
        map.forEach((k, v) -> System.out.println( v + " " + k));
    }
}
