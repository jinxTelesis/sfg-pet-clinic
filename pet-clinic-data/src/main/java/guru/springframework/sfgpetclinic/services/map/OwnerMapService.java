package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.services.CrudService;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.stfpetclinic.model.Owner;
import guru.springframework.stfpetclinic.model.PetType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

// you removed the CRUD SERVER MIGHT WANT TO PUT IT BACK
@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long>
        implements OwnerService {

    public OwnerMapService(PetTypeMapService petTypeMapService, PetMapService petMapService) {
        super();
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    // expand this for a real project to full version on section 8 lecture 157
    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }

    public static interface PetTypeService extends CrudService<PetType, Long> {

    }
}
