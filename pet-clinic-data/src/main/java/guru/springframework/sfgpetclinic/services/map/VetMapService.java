package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.stfpetclinic.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Set;

// we removed crud
@Service
public class VetMapService extends AbstractMapService<Vet, Long>
        implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}