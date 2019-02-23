package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.stfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
