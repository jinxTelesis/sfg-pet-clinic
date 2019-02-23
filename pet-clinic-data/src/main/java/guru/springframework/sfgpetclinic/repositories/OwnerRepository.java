package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.stfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);

}
