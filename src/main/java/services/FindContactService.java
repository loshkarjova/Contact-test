package services;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class FindContactService {

    private ContactsReaderService readerService = new ContactsReaderService();

    public void findContact(){
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Write Contact for finding: ");
            String contact = scanner.nextLine();
            Map<String, String> map = readerService.readContacts();
            List<String> s = map.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().contains(contact) || entry.getKey().contains(contact))
                    .map(entry -> entry.getValue() + " " + entry.getKey())
                    .toList();
            if (s.size()>0){
                System.out.println(s);
            }else {
                System.out.println("This Contact is absent.");
            }
        }

    }
}
