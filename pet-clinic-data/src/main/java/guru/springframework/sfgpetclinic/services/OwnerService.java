package guru.springframework.sfgpetclinic.services;

import guru.springframework.stfpetclinic.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
