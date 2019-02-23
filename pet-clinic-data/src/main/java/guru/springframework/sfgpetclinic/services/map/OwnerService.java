package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.stfpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
