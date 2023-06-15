package services;

public class AppService {
    private final ContactsWriterService writerService = new ContactsWriterService();
    private final ContactsReaderService readerService = new ContactsReaderService();
    private final FindContactService finderService = new FindContactService();
    private final ContactsDeleteService deleterService = new ContactsDeleteService();

    public void writeContact() {
        writerService.checkFile();
        writerService.addContact();
    }
    public void readService(){
        readerService.outputRead();
    }
    public void findService(){
        finderService.findContact();
    }
    public void deleteService(){
        deleterService.deleteContact();
    }



}
