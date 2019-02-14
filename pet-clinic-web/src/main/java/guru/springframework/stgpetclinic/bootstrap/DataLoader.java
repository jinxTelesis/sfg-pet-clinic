package guru.springframework.stgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // spring will load into context then run method
public class DataLoader implements CommandLineRunner {

    //private final OwnerService ownerService;
    //private final VetService vetService;

    public DataLoader(){

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
